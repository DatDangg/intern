package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.UserProfileResponse;
import com.bctt.dto.reponse.UserResponse;
import com.bctt.dto.request.UserProfileRequest;
import com.bctt.dto.request.UserRequest;
import com.bctt.model.Nganh;
import com.bctt.model.User;
import com.bctt.model.User_profile;
import com.bctt.repository.NganhRepository;
import com.bctt.repository.UserProfileRepository;
import com.bctt.repository.UserRepository;
import com.bctt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private NganhRepository nganhRepository;


    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = new User();
        user.setMaUser(userRequest.getMaUser());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setEmailDN(userRequest.getEmailDN());
        userRepository.save(user);
        return mapToUserResponse(user);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserProfileRequest userProfileRequest) {
        User user = userRepository.findById(id).orElseThrow();
        User_profile userProfile = user.getUserProfile();
        List<Nganh> nganh = (List<Nganh>) nganhRepository.findById(userProfileRequest.getMaNganh()).orElseThrow();
        if(userProfile == null) {
            userProfile = new User_profile();
            userProfile.setUser(user);
        }
        userProfile.setCCCD(userProfileRequest.getCCCD());
        userProfile.setEmailCN(userProfileRequest.getEmailCN());
        userProfile.setGioiTinh(userProfileRequest.getGioiTinh());
        userProfile.setLopHoc(userProfileRequest.getLopHoc());
        userProfile.setHoVaTen(userProfileRequest.getHoVaTen());
        userProfile.setSoDienthoai(userProfileRequest.getSoDienthoai());
        userProfile.setTinhTrang(userProfileRequest.getTinhTrang());
        userProfile.setNganhList(nganh);
        userProfileRepository.save(userProfile);
        return mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmailDN(user.getEmailDN());
        userResponse.setMaUser(user.getMaUser());
        userResponse.setPassword(user.getPassword());
        if (user.getUserProfile() != null) {
            UserProfileResponse userProfileResponse = new UserProfileResponse();
            userProfileResponse.setCCCD(user.getUserProfile().getCCCD());
            userProfileResponse.setEmailCN(user.getUserProfile().getEmailCN());
            userProfileResponse.setGioiTinh(user.getUserProfile().getGioiTinh());
            userProfileResponse.setLopHoc(user.getUserProfile().getLopHoc());
            userProfileResponse.setHoVaTen(user.getUserProfile().getHoVaTen());
            userProfileResponse.setSoDienthoai(user.getUserProfile().getSoDienthoai());
            userProfileResponse.setTinhTrang(user.getUserProfile().getTinhTrang());
            List<Nganh> nganhList = user.getUserProfile().getNganhList();
            if (nganhList != null && !nganhList.isEmpty()) {
                String tenNganh = nganhList.stream().map(Nganh::getTenNganh).collect(Collectors.joining(", "));
                String maNganh = nganhList.stream().map(Nganh::getMaNganh).collect(Collectors.joining(", "));
                userProfileResponse.setTenNganh(tenNganh);
                userProfileResponse.setMaNganh(maNganh);
            }
            userResponse.setUserProfileResponse(userProfileResponse);
        }
        return userResponse;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
