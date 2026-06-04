import { useEffect, useState } from "react";
import api from "../services/api";

function Dashboard() {

  const [data, setData] = useState(null);

  useEffect(() => {

    api.get("/dashboard")
      .then((response) => {

        setData(response.data);

      })
      .catch((error) => {

        console.error(error);

      });

  }, []);

  if (!data) {

    return <h2>Loading...</h2>;

  }

  return (
    <div>
      <h1>Dashboard Bengkel</h1>

      <p>Total Pelanggan: {data.totalPelanggan}</p>

      <p>Total Kendaraan: {data.totalKendaraan}</p>

      <p>Total Servis: {data.totalServis}</p>

      <p>Total Sparepart: {data.totalSparepart}</p>
    </div>
  );
}

export default Dashboard;