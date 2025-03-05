import React, { useState } from "react";
import axios from "axios";
import "./style.css";

const AlternativeSubject = () => {
    const [search, setSearch] = useState(""); // Giá trị mã môn tìm kiếm
    const [alternativeSubjects, setAlternativeSubjects] = useState([]); // Danh sách môn thay thế
    const [loading, setLoading] = useState(false); // Trạng thái chờ tải dữ liệu
    const [error, setError] = useState(null); // Trạng thái lỗi

    // Hàm tìm kiếm môn học thay thế
    const handleSearch = async () => {
        const maMonHoc = search.trim(); // Lấy mã môn học từ ô input

        if (!maMonHoc) {
            setError("Vui lòng nhập mã môn học.");
            return;
        }

        try {
            setLoading(true);
            setError(null);

            const response = await axios.get(`http://localhost:8888/admin/AllMonTTInMonHoc/${maMonHoc}`);
            console.log("Dữ liệu từ API:", response.data);

            if (response.data.length === 0) {
                setError("Không tìm thấy môn thay thế.");
                setAlternativeSubjects([]);
            } else {
                setAlternativeSubjects(response.data);
            }
        } catch (err) {
            console.error("Lỗi API:", err);
            setError("Lỗi khi tải môn học thay thế.");
        } finally {
            setLoading(false);
        }
    };

    return (

        <div className ="alter">
            <div className ="alter-header">
                <h1 className='alter-title'>Môn Thay Thế</h1>
                <div className="separator"></div>
            </div>
            <div className="alter-content">
                <div className="alter-filters">
                    <div className="search-box">
                        <input
                            type="text"
                            value={search}
                            onChange={(e) => setSearch(e.target.value)}
                            placeholder="Nhập mã môn"
                        />
                        <button onClick={handleSearch}>Tìm kiếm</button>
                    </div>
                    {error && <p className="error-message">{error}</p>}
                    {loading && <p className="loading-message">Đang tải dữ liệu...</p>}
                </div>
                <div className="alter-table_container">
                    <table className="alter-course_table">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Mã Môn</th>
                            <th>Tên Môn Thay Thế</th>
                            <th>Mã Môn Thay Thế</th>
                            <th>Số Tín Chỉ</th>
                        </tr>
                        </thead>
                        <tbody>
                        {alternativeSubjects.length === 0 ? (
                            <tr>
                                <td colSpan="5" className="no-data">Chưa có dữ liệu</td>
                            </tr>
                        ) : (
                            alternativeSubjects.map((subject, index) => (
                                <tr key={subject.maMonHoc || index}>
                                    <td>{index + 1}</td>
                                    <td>{subject.maMonHoc || "N/A"}</td>
                                    <td>{subject.tenMonThayThe || "N/A"}</td>
                                    <td>{subject.maMonThayThe || "N/A"}</td>
                                    <td>{subject.soTinChi || "N/A"}</td>
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

export default AlternativeSubject;