import React, { useEffect, useState } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const Backlog = () => {
  const [curriculums, setCurriculums] = useState([]); // Danh sách chương trình đào tạo
  const [selectedCurriculum, setSelectedCurriculum] = useState(""); // Curriculum được chọn
  const [years, setYears] = useState([]); // Danh sách năm học
  const [selectedYear, setSelectedYear] = useState(""); // Năm học được chọn
  const [courses, setCourses] = useState([]); // Danh sách môn học
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const loadData = async () => {
      try {
        const userId = localStorage.getItem("currentUser"); // Lấy id từ localStorage
        if (!userId) {
          throw new Error("Không tìm thấy thông tin người dùng.");
        }

        // Fetch user
        const userResponse = await axios.get(`http://localhost:3001/users/${userId}`);
        const userData = userResponse.data;
        const userCurriculumId = userData.curriculum;
        const userBatch = userData.batch; // Lấy batch của người dùng

        // Fetch batchYearMapping
        const mappingResponse = await axios.get("http://localhost:3001/batchYearMapping");
        const mappingData = mappingResponse.data;

        // Lấy danh sách các năm từ batchYearMapping
        const availableYears = mappingData.map((m) => m.year);
        setYears(availableYears);

        // Xác định năm mặc định dựa trên batch
        const batchYear = mappingData.find((m) => m.batch === userBatch);
        const defaultYear = batchYear ? batchYear.year : availableYears[0]; // Năm mặc định

        // Fetch curriculums
        const curriculumResponse = await axios.get("http://localhost:3001/curriculums");
        setCurriculums(curriculumResponse.data);

        // Fetch courses by curriculum
        const coursesResponse = await axios.get(
          `http://localhost:3001/backlogByCurriculum?curriculum=${userCurriculumId}`
        );
        const curriculumData = coursesResponse.data[0];

        // Set default curriculum and year
        setSelectedCurriculum(userCurriculumId);
        setSelectedYear(defaultYear);

        // Fetch default courses
        const yearData = curriculumData.years.find((y) => y.year === defaultYear);
        setCourses(yearData ? yearData.courses : []);

        setLoading(false);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải dữ liệu.");
        setLoading(false);
      }
    };

    loadData();
  }, []);

  // Update courses when curriculum or year changes
  useEffect(() => {
    const fetchCourses = async () => {
      if (selectedCurriculum && selectedYear) {
        try {
          const coursesResponse = await axios.get(
            `http://localhost:3001/backlogByCurriculum?curriculum=${selectedCurriculum}`
          );
          const curriculumData = coursesResponse.data[0];
          const yearData = curriculumData.years.find((y) => y.year === selectedYear);
          setCourses(yearData ? yearData.courses : []);
        } catch (err) {
          setError("Lỗi khi tải dữ liệu.");
        }
      }
    };

    fetchCourses();
  }, [selectedCurriculum, selectedYear]);

  const fetchCourses = async (curriculum, year) => {
    try {
      const response = await axios.get(
        `http://localhost:3001/coursesByCurriculum?curriculum=${curriculum}`
      );
      const curriculumData = response.data[0];
      const yearData = curriculumData.years.find((y) => y.year === year);
      setCourses(yearData ? yearData.courses : []);
    } catch (err) {
      setError("Lỗi khi tải dữ liệu.");
    }
  };
  

  if (loading) {
    return <div className="loading">Đang tải dữ liệu...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className="backlog">
      <div className="backlog-header">
        <h1 className="backlog-title">Môn Tồn Đọng</h1>
        <div className="separator"></div>
      </div>
      <div className="backlog-content">
        {/* Bộ lọc */}
        <div className="backlog-filters">
          <select
            value={selectedCurriculum}
            onChange={(e) => {
              const newCurriculum = e.target.value;
              setSelectedCurriculum(newCurriculum);
              fetchCourses(newCurriculum, selectedYear); // Gọi hàm chung để lấy dữ liệu
            }}
          >
            {curriculums.map((curriculum) => (
              <option key={curriculum.id} value={curriculum.id}>
                {curriculum.name}
              </option>
            ))}
          </select>
          <select
            value={selectedYear}
            onChange={(e) => {
              const newYear = e.target.value;
              setSelectedYear(newYear);
              fetchCourses(selectedCurriculum, newYear); // Gọi hàm chung để lấy dữ liệu
            }}
          >
            {years.map((year) => (
              <option key={year} value={year}>
                {year}
              </option>
            ))}
          </select>
        </div>


        {/* Bảng dữ liệu */}
        <div className="backlog-table_container">
          <table className="backlog-course_table">
            <thead>
              <tr>
                <th>STT</th>
                <th>Mã môn</th>
                <th>Tên môn</th>
                <th>Tỉ lệ</th>
                <th>Ghi chú</th>
              </tr>
            </thead>
            <tbody>
              {courses.length === 0 ? (
                <tr>
                  <td colSpan="5" className="no-data">
                    Chưa có dữ liệu
                  </td>
                </tr>
              ) : (
                courses.map((course, index) => (
                  <tr key={course.id}>
                    <td>{index + 1}</td>
                    <td>{course.code}</td>
                    <td>{course.name}</td>
                    <td>{course.percentage}</td>
                    <td>{course.state}</td>
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

export default Backlog;
