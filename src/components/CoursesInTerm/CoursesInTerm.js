import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const CoursesInTerm = () => {
  // Danh sách năm học lấy từ list ngành (namDaotao)
  const [academicYears, setAcademicYears] = useState([]); 
  const [selectedYear, setSelectedYear] = useState("");
  // Học kỳ và nhóm cố định: chỉ có 1, 2, 3
  const semesters = ["1", "2", "3"];
  const [selectedSemester, setSelectedSemester] = useState("");
  const groups = ["1", "2", "3"];
  const [selectedGroup, setSelectedGroup] = useState("");

  // Danh sách môn học trả về từ API TKB
  const [courses, setCourses] = useState([]); 
  const [filteredCourses, setFilteredCourses] = useState([]); 
  const [searchTerm, setSearchTerm] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const location = useLocation();
  const courseDetails = location.state || {}; 

  // Load danh sách ngành để lấy ra tất cả các năm học tồn tại (namDaotao)
  useEffect(() => {
    const loadAcademicYears = async () => {
      try {
        const response = await axios.get("http://localhost:8888/admin/listNganh");
        // Giả sử response.data là một mảng đối tượng có trường "namDaotao"
        const years = Array.from(
          new Set(response.data.map((item) => item.namDaotao))
        );
        setAcademicYears(years);
        // Chọn năm mặc định là năm đầu tiên
        const defaultYear = years[0];
        setSelectedYear(defaultYear);
        // Đặt mặc định học kỳ và nhóm là phần tử đầu của mảng cố định
        setSelectedSemester(semesters[0]);
        setSelectedGroup(groups[0]);
        fetchCourses(defaultYear, semesters[0], groups[0]);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải danh sách năm học từ danh sách ngành.");
      } finally {
        setLoading(false);
      }
    };

    loadAcademicYears();
  }, []);

  // Hàm gọi API TKB mới theo năm, học kỳ và nhóm học
  const fetchCourses = async (year, semester, group) => {
    try {
      const response = await axios.get(
        `http://localhost:8888/admin/TKB/${year}/${semester}/${group}`
      );
      // API trả về trực tiếp mảng các đối tượng course
      setCourses(response.data);
      setFilteredCourses(response.data);
    } catch (err) {
      console.error(err);
      setError("Lỗi khi tải danh sách môn học.");
    }
  };

  const handleYearChange = (newYear) => {
    setSelectedYear(newYear);
    fetchCourses(newYear, selectedSemester, selectedGroup);
  };

  const handleSemesterChange = (newSemester) => {
    setSelectedSemester(newSemester);
    fetchCourses(selectedYear, newSemester, selectedGroup);
  };

  const handleGroupChange = (newGroup) => {
    setSelectedGroup(newGroup);
    fetchCourses(selectedYear, selectedSemester, newGroup);
  };

  const handleSearch = () => {
    const searchResult = courses.filter(
      (course) =>
        course.tenMonHoc.toLowerCase().includes(searchTerm.toLowerCase()) ||
        course.maMonHoc.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredCourses(searchResult);
  };

  // Nếu có thông tin chi tiết môn học được chuyển qua từ trang khác
  useEffect(() => {
    if (courseDetails.maMonHoc) {
      const fetchFilteredCourses = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8888/admin/TKB/${courseDetails.namHoc}/${courseDetails.kiHoc}/${courseDetails.nhomHoc}`
          );
          const data = response.data || [];
          const filtered = data.filter(
            (course) => course.maMonHoc === courseDetails.maMonHoc
          );
          setFilteredCourses(filtered);
        } catch (err) {
          console.error(err);
        }
      };

      fetchFilteredCourses();
    }
  }, [courseDetails]);

  if (loading) {
    return <div className="loading">Đang tải dữ liệu...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className="courses-term">
      <div className="courses-term__header">
        <h1 className="courses-term__title">Môn Trong Kỳ</h1>
        <div className="separator"></div>
      </div>
      <div className="courses-term__content">
        <div className="courses-term__filters">
          <div className="filters-left">
            <select
              value={selectedYear}
              onChange={(e) => handleYearChange(e.target.value)}
            >
              {academicYears.map((year) => (
                <option key={year} value={year}>
                  {year}
                </option>
              ))}
            </select>
            <select
              value={selectedSemester}
              onChange={(e) => handleSemesterChange(e.target.value)}
            >
              {semesters.map((semester) => (
                <option key={semester} value={semester}>
                  Học kỳ {semester}
                </option>
              ))}
            </select>
            <select
              value={selectedGroup}
              onChange={(e) => handleGroupChange(e.target.value)}
            >
              {groups.map((group) => (
                <option key={group} value={group}>
                  Nhóm {group}
                </option>
              ))}
            </select>
          </div>
          <div className="filters-right">
            <form
              className="search-bar"
              onSubmit={(e) => {
                e.preventDefault();
                handleSearch();
              }}
            >
              <input
                type="text"
                placeholder="Nhập môn học..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
              />
              <button type="submit">
                <svg
                  width="20px"
                  height="20px"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    fillRule="evenodd"
                    clipRule="evenodd"
                    d="M10 5C7.23858 5 5 7.23858 5 10C5 12.7614 7.23858 15 10 15C11.381 15 12.6296 14.4415 13.5355 13.5355C14.4415 12.6296 15 11.381 15 10C15 7.23858 12.7614 5 10 5ZM3 10C3 6.13401 6.13401 3 10 3C13.866 3 17 6.13401 17 10C17 11.5719 16.481 13.0239 15.6063 14.1921L20.7071 19.2929C21.0976 19.6834 21.0976 20.3166 20.7071 20.7071C20.3166 21.0976 19.6834 21.0976 19.2929 20.7071L14.1921 15.6063C13.0239 16.481 11.5719 17 10 17C6.13401 17 3 13.866 3 10Z"
                    fill="#ffffff"
                  />
                </svg>
              </button>
            </form>
          </div>
        </div>
        <div className="courses-term__table-content">
          <table className="courses-term__table">
            <thead>
              <tr>
                <th>STT</th>
                <th>Mã môn</th>
                <th>Tên môn</th>
                <th>Tên lớp</th>
                <th>Thứ</th>
                <th>Ca</th>
                <th>Phòng học</th>
                <th>Giảng viên</th>
              </tr>
            </thead>
            <tbody>
              {filteredCourses.length === 0 ? (
                <tr>
                  <td colSpan="8" className="no-data">
                    Không có dữ liệu
                  </td>
                </tr>
              ) : (
                filteredCourses.map((course, index) => (
                  <tr key={course.maMonHoc + index}>
                    <td>{index + 1}</td>
                    <td>{course.maMonHoc}</td>
                    <td>{course.tenMonHoc}</td>
                    <td>{course.tenLop}</td>
                    <td>{course.ngayHoc}</td>
                    <td>{course.caHoc}</td>
                    <td>{course.phongHoc}</td>
                    <td>{course.giangVien}</td>
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

export default CoursesInTerm;
