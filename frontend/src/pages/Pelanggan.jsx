import { useEffect, useState } from "react";
import api from "../services/api";

function Pelanggan() {

  const [pelanggan, setPelanggan] = useState([]);

  const [form, setForm] = useState({
    nama: "",
    nomorHp: "",
    alamat: ""
  });

  const loadData = () => {

    api.get("/pelanggan")
      .then((response) => {

        setPelanggan(response.data);

      });

  };

  useEffect(() => {

    loadData();

  }, []);

  const handleChange = (e) => {

    setForm({
      ...form,
      [e.target.name]: e.target.value
    });

  };

  const handleSubmit = (e) => {

    e.preventDefault();

    api.post("/pelanggan", form)
      .then(() => {

        loadData();

        setForm({
          nama: "",
          nomorHp: "",
          alamat: ""
        });

      })
      .catch((error) => {

        console.error(error);

      });

  };

  const handleDelete = (id) => {

  if (!window.confirm("Hapus pelanggan ini?")) {
    return;
  }

  api.delete(`/pelanggan/${id}`)
    .then(() => {

      loadData();

    })
    .catch((error) => {

      console.error(error);

    });

    };

  return (
    <div>

      <h1>Data Pelanggan</h1>

      <h3>Tambah Pelanggan</h3>

      <form onSubmit={handleSubmit}>

        <input
          type="text"
          name="nama"
          placeholder="Nama"
          value={form.nama}
          onChange={handleChange}
        />

        <br /><br />

        <input
          type="text"
          name="nomorHp"
          placeholder="Nomor HP"
          value={form.nomorHp}
          onChange={handleChange}
        />

        <br /><br />

        <input
          type="text"
          name="alamat"
          placeholder="Alamat"
          value={form.alamat}
          onChange={handleChange}
        />

        <br /><br />

        <button type="submit">
          Simpan
        </button>

      </form>

      <hr />

      <table border="1" cellPadding="10">

        <thead>

          <tr>
            <th>ID</th>
            <th>Nama</th>
            <th>No HP</th>
            <th>Alamat</th>
            <th>Aksi</th>
          </tr>

        </thead>

        <tbody>

          {pelanggan.map((p) => (

            <tr key={p.id}>

              <td>{p.id}</td>
              <td>{p.nama}</td>
              <td>{p.nomorHp}</td>
              <td>{p.alamat}</td>

               <td>
                    <button
                        onClick={() => handleDelete(p.id)}
                    >
                        Hapus
                    </button>
                </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default Pelanggan;