import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import api from "../../services/api"; 
import "../../variables.css";
import "./style.css";

const CoursesInTerm = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const courseDetails = location.state || null;

  const [academicYears, setAcademicYears] = useState([]);
  const semesters = ["1", "2", "3"];
  const groups = ["1", "2", "3"];

  const [selectedYear, setSelectedYear] = useState(courseDetails?.namHoc || "");
  const [selectedSemester, setSelectedSemester] = useState(
    courseDetails?.kiHoc || ""
  );
  const [selectedGroup, setSelectedGroup] = useState(
    courseDetails?.nhomHoc || ""
  );

  const [courses, setCourses] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    console.log("Dữ liệu state từ Backlog.js:", courseDetails);
  }, [courseDetails]);

  useEffect(() => {
    const fetchAcademicYears = async () => {
      try {
        const response = await api.get(
          "/admin/listNganh"
        );
        const years = Array.from(
          new Set(response.data.map((item) => item.namDaotao))
        );
        setAcademicYears(years);

        if (!courseDetails) {
          setSelectedYear(years[0] || "");
          setSelectedSemester(semesters[0]);
          setSelectedGroup(groups[0]);
        }
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải danh sách năm học từ danh sách ngành.");
      } finally {
        setLoading(false);
      }
    };

    fetchAcademicYears();
  }, []);

  useEffect(() => {
    if (selectedYear && selectedSemester && selectedGroup) {
      fetchCourses(selectedYear, selectedSemester, selectedGroup);
    }
  }, [selectedYear, selectedSemester, selectedGroup]);

  const fetchCourses = async (year, semester, group) => {
    try {
      setLoading(true);
      const response = await api.get(
        `/admin/TKB/${year}/${semester}/${group}`
      );
      const allCourses = response.data || [];

      const highlightedCourses = allCourses.map((course) => ({
        ...course,
        isHighlighted: courseDetails?.maMonHoc === course.maMonHoc,
      }));

      setCourses(highlightedCourses);
    } catch (err) {
      console.error(err);
      setError("Lỗi khi tải danh sách môn học.");
    } finally {
      setLoading(false);
    }
  };

  const handleYearChange = (newYear) => {
    setSelectedYear(newYear);
  };

  const handleSemesterChange = (newSemester) => {
    setSelectedSemester(newSemester);
  };

  const handleGroupChange = (newGroup) => {
    setSelectedGroup(newGroup);
  };

  const handleSearch = () => {
    const searchResult = courses.filter(
      (course) =>
        course.tenMonHoc.toLowerCase().includes(searchTerm.toLowerCase()) ||
        course.maMonHoc.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setCourses(searchResult);
  };

  if (loading) {
    return <div className="loading">Đang tải dữ liệu...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className="courses-term">
      <div className="courses-term__header">
        <h1 className="courses-term__title">Thời Khóa Biểu</h1>
        <h2 className="courses-term__subtitle">
          Kì {selectedSemester} &ensp;Nhóm {selectedGroup} &ensp;Năm {selectedYear}
        </h2>
        <div className="separator"></div>
      </div>

      <div className="courses-term__content">
        <div className="courses-term__filters">
          <div className="filters-left">
            <div className="filter-item">
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
              <div className="filter-name">Năm học</div>
            </div>
            <div className="filter-item">
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
              <div className="filter-name">Học kỳ</div>
            </div>
            <div className="filter-item">
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
              <div className="filter-name">Nhóm</div>
            </div>
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
              {courses.length === 0 ? (
                <tr>
                  <td colSpan="8" className="no-data">
                    Không có dữ liệu
                  </td>
                </tr>
              ) : (
                courses.map((course, index) => (
                  <tr
                    key={course.maMonHoc + index}
                    className={
                      course.isHighlighted ? "courses-term__highlight" : ""
                    }
                  >
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
