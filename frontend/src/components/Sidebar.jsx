import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div
      style={{
        width: "220px",
        background: "#1f2937",
        color: "white",
        minHeight: "100vh",
        padding: "20px"
      }}
    >
      <h2>Bengkel App</h2>

      <ul style={{ listStyle: "none", padding: 0 }}>
        <li>
          <Link to="/" style={{ color: "white" }}>
            Dashboard
          </Link>
        </li>

        <li>
          <Link to="/pelanggan" style={{ color: "white" }}>
            Pelanggan
          </Link>
        </li>

        <li>
          <Link to="/kendaraan" style={{ color: "white" }}>
            Kendaraan
          </Link>
        </li>

        <li>
          <Link to="/sparepart" style={{ color: "white" }}>
            Sparepart
          </Link>
        </li>

        <li>
          <Link to="/servis" style={{ color: "white" }}>
            Servis
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;