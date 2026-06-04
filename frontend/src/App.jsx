import { Routes, Route } from "react-router-dom";

import Sidebar from "./components/Sidebar";

import Dashboard from "./pages/Dashboard";
import Pelanggan from "./pages/Pelanggan";
import Kendaraan from "./pages/Kendaraan";
import Sparepart from "./pages/Sparepart";
import Servis from "./pages/Servis";

function App() {
  return (
    <div style={{ display: "flex" }}>
      <Sidebar />

      <div style={{ padding: "20px", flex: 1 }}>
        <Routes>
          <Route path="/" element={<Dashboard />} />

          <Route
            path="/pelanggan"
            element={<Pelanggan />}
          />

          <Route
            path="/kendaraan"
            element={<Kendaraan />}
          />

          <Route
            path="/sparepart"
            element={<Sparepart />}
          />

          <Route
            path="/servis"
            element={<Servis />}
          />
        </Routes>
      </div>
    </div>
  );
}

export default App;