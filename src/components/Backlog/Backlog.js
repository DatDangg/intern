import React, { useEffect, useState } from "react";
import axios from "axios";
import "../../variables.css";
import "./style.css";

const Backlog = () => {
  // 1. Thông tin user để lấy maNganh mặc định
  const [userMajorCode, setUserMajorCode] = useState(""); // VD: "TT35"

  // 2. Danh sách ngành (listNganh) trả về từ API
  const [listNganh, setListNganh] = useState([]);

  // 3. Dropdown "Tên ngành" (không lặp)
  const [selectedTenNganh, setSelectedTenNganh] = useState("");

  // 4. Dropdown "Năm đào tạo" (theo tên ngành đã chọn)
  const [years, setYears] = useState([]);
  const [selectedYear, setSelectedYear] = useState("");

  // 5. Danh sách môn tồn đọng (sau khi gọi API AllMonTD)
  const [subjects, setSubjects] = useState([]);

  // 6. Trạng thái tải / lỗi
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  /**
   * Bước A: Lấy userMajorCode từ userProfileResponse.lopHoc
   *   (giả sử localStorage lưu "maUser" khi login)
   */
  useEffect(() => {
    const fetchUserMajor = async () => {
      try {
        const userId = localStorage.getItem("maUser");
        if (!userId) {
          throw new Error("Không tìm thấy thông tin người dùng (maUser).");
        }
        const response = await axios.get(`http://localhost:8888/admin/getId/${userId}`);
        const userData = response.data;
        // "lopHoc" chính là mã ngành của user (VD: "TT35")
        const majorCode = userData.userProfileResponse.lopHoc;
        setUserMajorCode(majorCode);
      } catch (err) {
        console.error(err);
        setError("Lỗi khi tải thông tin người dùng.");
        setLoading(false);
      }
    };
    fetchUserMajor();
  }, []);

  /**
   * Bước B: Lấy toàn bộ listNganh (maNganh, tenNganh, namDaotao, ...)
   */
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

  /**
   * Bước C: Tạo danh sách "tenNganh" duy nhất để hiển thị trong dropdown.
   * - Mỗi "tenNganh" chỉ hiển thị 1 lần, tránh trùng lặp.
   */
  const uniqueTenNganh = Array.from(
    new Set(listNganh.map((item) => item.tenNganh))
  ); // Mảng tên ngành duy nhất

  /**
   * Bước D: Khi đã có userMajorCode và listNganh,
   *   ta tìm "tenNganh" mặc định để hiển thị (nếu muốn auto-chọn theo user).
   */
  useEffect(() => {
    if (!userMajorCode || listNganh.length === 0) return;
  
    // Chỉ set mặc định khi chưa có selectedTenNganh
    if (!selectedTenNganh) {
      const found = listNganh.find((item) => item.maNganh === userMajorCode);
      if (found) {
        setSelectedTenNganh(found.tenNganh);
        setSelectedYear(found.namDaotao); // Set luôn năm đào tạo theo user
      } else {
        setSelectedTenNganh(uniqueTenNganh[0] || "");
      }
    }
  }, [userMajorCode, listNganh, uniqueTenNganh, selectedTenNganh]);
  
  

  /**
   * Bước E: Mỗi khi selectedTenNganh thay đổi,
   *   ta xây dựng danh sách năm đào tạo (unique) cho tên ngành đó.
   */
  useEffect(() => {
    if (!selectedTenNganh) return;
    // Lọc listNganh lấy các record có tenNganh = selectedTenNganh
    const filtered = listNganh.filter(
      (item) => item.tenNganh === selectedTenNganh
    );
    // Tạo mảng năm đào tạo duy nhất
    const availableYears = [...new Set(filtered.map((f) => f.namDaotao))];
    setYears(availableYears);

    // Nếu selectedYear chưa có hoặc không nằm trong availableYears, chọn năm đầu
    if (!availableYears.includes(selectedYear)) {
      setSelectedYear(availableYears[0] || "");
    }
  }, [selectedTenNganh, listNganh, selectedYear]);

  /**
   * Bước F: Khi selectedTenNganh hoặc selectedYear thay đổi,
   *   ta tìm "maNganh" tương ứng => Gọi API AllMonTD/{maNganh}/{namDaotao}
   */
  useEffect(() => {
    const fetchSubjects = async () => {
      if (!selectedTenNganh || !selectedYear) return;

      // Tìm record trong listNganh khớp với (tenNganh, namDaotao)
      const found = listNganh.find(
        (item) =>
          item.tenNganh === selectedTenNganh &&
          item.namDaotao === selectedYear
      );
      if (!found) {
        // Không tìm thấy record => không có maNganh => clear subjects
        setSubjects([]);
        return;
      }

      const { maNganh } = found; // Lấy maNganh từ record
      try {
        setLoading(true);
        const url = `http://localhost:8888/admin/AllMonTD/${maNganh}/${selectedYear}`;
        const response = await axios.get(url);
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

  // Nếu đang loading (trước khi có dữ liệu)
  if (loading && !error) {
    return <div className="loading">Đang tải dữ liệu...</div>;
  }

  // Nếu có lỗi
  if (error) {
    return <div className="error">{error}</div>;
  }

  // Render giao diện
  return (
    <div className="backlog">
      <div className="backlog-header">
        <h1 className="backlog-title">Môn Tồn Đọng</h1>
        <div className="separator"></div>
      </div>
      <div className="backlog-content">
        {/* Bộ lọc */}
        <div className="backlog-filters">
          {/* Dropdown Tên ngành (không trùng lặp) */}
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

          {/* Dropdown Năm đào tạo */}
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
        </div>

        {/* Bảng dữ liệu: hiển thị môn tồn đọng */}
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
                subjects.map((subject, index) => (
                  <tr key={subject.maMonTonDong + index}>
                    <td>{index + 1}</td>
                    <td>{subject.maMonTonDong}</td>
                    <td>{subject.tenMonTon}</td>
                    <td>{subject.ghiChu}</td>
                    <td>{subject.tiLe}</td>
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
