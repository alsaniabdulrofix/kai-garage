import { useEffect, useState } from "react";
import api from "../services/api";

function Sparepart() {

  const [sparepart, setSparepart] = useState([]);

  useEffect(() => {

    api.get("/sparepart")
      .then((response) => {

        setSparepart(response.data);

      })
      .catch((error) => {

        console.error(error);

      });

  }, []);

  return (
    <div>
      <h1>Data Sparepart</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nama</th>
            <th>Harga</th>
            <th>Stok</th>
          </tr>
        </thead>

        <tbody>
          {sparepart.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.nama}</td>
              <td>Rp {s.harga}</td>
              <td>{s.stok}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Sparepart;