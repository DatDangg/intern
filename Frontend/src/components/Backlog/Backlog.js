import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import "../../variables.css";
import "./style.css";

const Backlog = () => {
  const [userMajorCode, setUserMajorCode] = useState("");
  const [listNganh, setListNganh] = useState([]);
  const [selectedTenNganh, setSelectedTenNganh] = useState("");
  const [years, setYears] = useState([]);
  const [selectedYear, setSelectedYear] = useState("");
  const [subjects, setSubjects] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [latestTKB, setLatestTKB] = useState(null);

  useEffect(() => {
    const fetchUserMajor = async () => {
      try {
        const userId = localStorage.getItem("maUser");
        if (!userId) {
          throw new Error("Không tìm thấy thông tin người dùng (maUser).");
        }
        const response = await api.get(`/admin/getId/${userId}`);
        const userData = response.data.userProfileResponse;

        if (!userData.maNganh) {
          throw new Error("Không tìm thấy thông tin ngành của user.");
        }

        setUserMajorCode(userData.maNganh);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải thông tin người dùng.");
        setLoading(false);
      }
    };
    fetchUserMajor();
  }, []);

  useEffect(() => {
    const fetchListNganh = async () => {
      try {
        const response = await api.get("/admin/listNganh");
        setListNganh(response.data);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải danh sách ngành.");
        setLoading(false);
      }
    };
    fetchListNganh();
  }, []);

  const uniqueTenNganh = Array.from(
    new Set(listNganh.map((item) => item.tenNganh))
  );

  useEffect(() => {
    if (!userMajorCode || listNganh.length === 0) return;

    if (!selectedTenNganh) {
      const found = listNganh.find((item) => item.maNganh === userMajorCode);
      if (found) {
        setSelectedTenNganh(found.tenNganh);
        setSelectedYear(found.namDaotao);
      } else {
        setSelectedTenNganh(uniqueTenNganh[0] || "");
      }
    }
  }, [userMajorCode, listNganh, uniqueTenNganh, selectedTenNganh]);

  useEffect(() => {
    if (!selectedTenNganh) return;
    const filtered = listNganh.filter(
      (item) => item.tenNganh === selectedTenNganh
    );
    const availableYears = [...new Set(filtered.map((f) => f.namDaotao))];
    setYears(availableYears);

    if (!availableYears.includes(selectedYear)) {
      setSelectedYear(availableYears[0] || "");
    }
  }, [selectedTenNganh, listNganh, selectedYear]);

  useEffect(() => {
    const fetchSubjects = async () => {
      if (!selectedTenNganh || !selectedYear) return;

      const found = listNganh.find(
        (item) =>
          item.tenNganh === selectedTenNganh && item.namDaotao === selectedYear
      );
      if (!found) {
        setSubjects([]);
        return;
      }

      const { maNganh } = found;
      try {
        setLoading(true);
        const url = `/admin/AllMonTD/${maNganh}/${selectedYear}`;
        const response = await api.get(url);
        setSubjects(response.data);
        setLoading(false);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải danh sách môn tồn đọng.");
        setLoading(false);
      }
    };
    fetchSubjects();
  }, [selectedTenNganh, selectedYear, listNganh]);

  useEffect(() => {
    const fetchLatestTKB = async () => {
      try {
        if (listNganh.length === 0) return;

        const availableYears = [
          ...new Set(listNganh.map((item) => item.namDaotao)),
        ];
        const latestYear = availableYears.sort().reverse()[0];

        if (!latestYear) return;

        const response = await api.get(`/admin/TKB/${latestYear}`);
        const tkbData = response.data;

        if (tkbData.length === 0) return;

        const sortedTKB = [...tkbData].sort((a, b) => {
          if (b.kiHoc !== a.kiHoc) return Number(b.kiHoc) - Number(a.kiHoc);
          return Number(b.nhomHoc) - Number(a.nhomHoc);
        });

        setLatestTKB(sortedTKB[0]);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải danh sách TKB.");
      }
    };

    fetchLatestTKB();
  }, [listNganh]);

  if (loading && !error) {
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
          <div className="filter-item">
            <select
              value={selectedTenNganh}
              onChange={(e) => setSelectedTenNganh(e.target.value)}
            >
              {uniqueTenNganh.map((ten) => (
                <option key={ten} value={ten}>
                  {ten}
                </option>
              ))}
            </select>
            <div className="filter-name">Ngành</div>
          </div>
          <div className="filter-item">
            <select
              value={selectedYear}
              onChange={(e) => setSelectedYear(e.target.value)}
            >
              {years.map((yr) => (
                <option key={yr} value={yr}>
                  {yr}
                </option>
              ))}
            </select>
            <div className="filter-name">Năm học</div>
          </div>
        </div>

        {/* Bảng dữ liệu môn tồn đọng */}
        <div className="backlog-table_container">
          <table className="backlog-course_table">
            <thead>
              <tr>
                <th>STT</th>
                <th>Mã môn tồn đọng</th>
                <th>Tên môn tồn đọng</th>
                <th>Trạng thái</th>
                <th>Tỉ lệ</th>
              </tr>
            </thead>
            <tbody>
              {subjects.length === 0 ? (
                <tr>
                  <td colSpan="5" className="no-data">
                    Chưa có dữ liệu
                  </td>
                </tr>
              ) : (
                subjects.map((subject, index) => {
                  const isOpen =
                    latestTKB &&
                    latestTKB.maMonHoc &&
                    latestTKB.maMonHoc === subject.maMonTonDong;

                  const tkbData = {
                    maMonHoc: subject.maMonTonDong,
                    namHoc: latestTKB?.namHoc || "",
                    kiHoc: latestTKB?.kiHoc || "",
                    nhomHoc: latestTKB?.nhomHoc || "",
                  };

                  return (
                    <tr key={subject.maMonTonDong + index}>
                      <td>{index + 1}</td>
                      <td>{subject.maMonTonDong}</td>
                      <td>{subject.tenMonTon}</td>
                      <td>
                        {isOpen ? (
                          <Link
                            to="/courses-in-term"
                            state={tkbData}
                            className="state_link"
                          >
                            Mở
                          </Link>
                        ) : (
                          "Đóng"
                        )}
                      </td>
                      <td>{subject.tiLe}</td>
                    </tr>
                  );
                })
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Backlog;
