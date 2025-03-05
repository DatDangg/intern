import React, { useEffect, useState } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const StudyProgram = () => {
    // 1. Thông tin user (maNganh)
    const [userMajorCode, setUserMajorCode] = useState("");

    // 2. Danh sách ngành từ API listNganh
    const [listNganh, setListNganh] = useState([]);

    // 3. Dropdown chọn ngành & năm đào tạo
    const [selectedTenNganh, setSelectedTenNganh] = useState(""); // Lưu tên ngành duy nhất
    const [selectedYear, setSelectedYear] = useState("");

    // 4. Mã ngành & mã CTDT
    const [selectedMaNganh, setSelectedMaNganh] = useState("");
    const [codeProgram, setCodeProgram] = useState("");

    // 5. Danh sách môn học
    const [subjects, setSubjects] = useState([]);

    // 6. Trạng thái tải / lỗi
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // A. Lấy maNganh của user từ API getId
    useEffect(() => {
        const fetchUserMajor = async () => {
            try {
                const userId = localStorage.getItem("maUser");
                if (!userId) {
                    throw new Error("Không tìm thấy thông tin người dùng (maUser).");
                }
                const response = await axios.get(`http://localhost:8888/admin/getId/${userId}`);
                const userData = response.data.userProfileResponse;

                if (!userData.lopHoc) {
                    throw new Error("Không tìm thấy thông tin ngành của user.");
                }

                setUserMajorCode(userData.lopHoc);
            } catch (err) {
                console.error("Lỗi chi tiết:", err); // In lỗi ra console
                setError("Lỗi khi tải thông tin người dùng.");
                setLoading(false);
            }
        };
        fetchUserMajor();
    }, []);

    // B. Lấy danh sách ngành từ API listNganh
    useEffect(() => {
        const fetchListNganh = async () => {
            try {
                const response = await axios.get("http://localhost:8888/admin/listNganh");
                setListNganh(response.data);
            } catch (err) {
                console.error(err);
                setError("Lỗi khi tải danh sách ngành.");
                setLoading(false);
            }
        };
        fetchListNganh();
    }, []);

    // C. Khi có userMajorCode, tự động chọn ngành và năm đào tạo mặc định
    useEffect(() => {
        if (!userMajorCode || listNganh.length === 0) return;

        const found = listNganh.find((item) => item.maNganh === userMajorCode);
        if (found) {
            setSelectedTenNganh(found.tenNganh);
            setSelectedYear(found.namDaotao);
            setSelectedMaNganh(found.maNganh);
            if (found.ctdts && found.ctdts.length > 0) {
                setCodeProgram(found.ctdts[0].maCTDT);
            }
        }
    }, [userMajorCode, listNganh]);

    // D. Khi chọn ngành, cập nhật danh sách năm đào tạo
    const availableYears = listNganh
        .filter((item) => item.tenNganh === selectedTenNganh)
        .map((item) => item.namDaotao);

    // Khi chọn năm, cập nhật maNganh & maCTDT
    useEffect(() => {
        if (!selectedTenNganh || !selectedYear) return;

        const found = listNganh.find(
            (item) => item.tenNganh === selectedTenNganh && item.namDaotao === selectedYear
        );

        if (found) {
            setSelectedMaNganh(found.maNganh);
            if (found.ctdts && found.ctdts.length > 0) {
                setCodeProgram(found.ctdts[0].maCTDT);
            } else {
                setCodeProgram("");
            }
        }
    }, [selectedTenNganh, selectedYear, listNganh]);

    // E. Khi có maCTDT, gọi API lấy danh sách môn học
    useEffect(() => {
        const fetchSubjects = async () => {
            if (!codeProgram) return;

            try {
                setLoading(true);
                const url = `http://localhost:8888/admin/AllMonHocInCTDT/${codeProgram}`;
                const response = await axios.get(url);
                setSubjects(response.data);
                setLoading(false);
            } catch (err) {
                console.error(err);
                setError("Lỗi khi tải chương trình đào tạo.");
                setLoading(false);
            }
        };
        fetchSubjects();
    }, [codeProgram]);

    // Lấy danh sách ngành duy nhất cho dropdown
    const uniqueTenNganh = Array.from(
        new Set(listNganh.map((item) => item.tenNganh))
    );

    // --- Rendering ---
    if (loading && !error) {
        return <div className="loading">Đang tải dữ liệu...</div>;
    }

    if (error) {
        return <div className="error">{error}</div>;
    }

    return (
        <div className="studyprogram">
            <div className="studyprogram-header">
                <h1 className="studyprogram-title">Chương trình đào tạo</h1>
                <div className="separator"></div>
            </div>
            <div className="studyprogram-content">
                {/* Bộ lọc */}
                <div className="studyprogram-filters">
                    <select
                        value={selectedTenNganh}
                        onChange={(e) => setSelectedTenNganh(e.target.value)}
                    >
                        {uniqueTenNganh.map((tenNganh) => (
                            <option key={tenNganh} value={tenNganh}>
                                {tenNganh}
                            </option>
                        ))}
                    </select>

                    <select
                        value={selectedYear}
                        onChange={(e) => setSelectedYear(e.target.value)}
                    >
                        {availableYears.map((year) => (
                            <option key={year} value={year}>
                                {year}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Bảng dữ liệu chương trình đào tạo */}
                <div className="studyprogram-table_container">
                    <table className="studyprogram-course_table">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Mã Môn</th>
                                <th>Tên Môn</th>
                                <th>Hệ số</th>
                                <th>Số giờ</th>
                                <th>Điều kiện tiên quyết</th>
                            </tr>
                        </thead>
                        <tbody>
                            {subjects.length === 0 ? (
                                <tr>
                                    <td colSpan="6" className="no-data">
                                        Chưa có dữ liệu
                                    </td>
                                </tr>
                            ) : (
                                subjects.map((subject, index) => (
                                    <tr key={subject.maMonHoc || index}>
                                        <td>{index + 1}</td>
                                        <td>{subject.maMonHoc || "N/A"}</td>
                                        <td>{subject.tenMonHoc || "N/A"}</td>
                                        <td>{subject.heSo || "N/A"}</td>
                                        <td>{subject.soGio || "N/A"}</td>
                                        <td>{subject.dieuKienTienQuyet || "Không có"}</td>
                                    </tr>
                                ))
                            )}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default StudyProgram;