import { useEffect, useState } from "react";
import api from "../services/api";

function Kendaraan() {

  const [kendaraan, setKendaraan] = useState([]);

  useEffect(() => {

    api.get("/kendaraan")
      .then((response) => {

        setKendaraan(response.data);

      })
      .catch((error) => {

        console.error(error);

      });

  }, []);

  return (
    <div>
      <h1>Data Kendaraan</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nomor Polisi</th>
            <th>Merk</th>
            <th>Tipe</th>
            <th>Tahun</th>
            <th>Pelanggan</th>
          </tr>
        </thead>

        <tbody>
          {kendaraan.map((k) => (
            <tr key={k.id}>
              <td>{k.id}</td>
              <td>{k.nomorPolisi}</td>
              <td>{k.merk}</td>
              <td>{k.tipe}</td>
              <td>{k.tahun}</td>
              <td>{k.pelanggan?.nama}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Kendaraan;