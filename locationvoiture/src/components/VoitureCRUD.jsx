import { useEffect, useState } from 'react';
import axios from 'axios';

const VoitureCRUD = () => {
    const [voitures, setVoitures] = useState([]);
    const [newVoiture, setNewVoiture] = useState({ marque: '', prix: '' });
    const [editing, setEditing] = useState(false);
    const [currentVoiture, setCurrentVoiture] = useState(null);

    const fetchVoitures = async () => {
        const response = await axios.get('http://localhost:9090/voiture');
        setVoitures(response.data);
    };

    useEffect(() => {
        fetchVoitures();
    }, []);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewVoiture({ ...newVoiture, [name]: value });
    };

    const createVoiture = async () => {
        await axios.post('http://localhost:9090/voiture/create', newVoiture);
        setNewVoiture({ marque: '', prix: '' });
        fetchVoitures();
    };

    const deleteVoiture = async (id) => {
        try {
            await axios.delete(`http://localhost:9090/voiture/delete/${id}`);
            fetchVoitures();
        } catch (error) {
            console.error('There was an error deleting the voiture!', error);
        }
    };

    const editVoiture = (voiture) => {
        setEditing(true);
        setCurrentVoiture(voiture);
        setNewVoiture({ marque: voiture.marque, prix: voiture.prix });
    };

    const updateVoiture = async () => {
        await axios.put(`http://localhost:9090/voiture/${currentVoiture.id}`, newVoiture);
        setEditing(false);
        setNewVoiture({ marque: '', prix: '' });
        fetchVoitures();
    };
    

    return (
        <div className="container mt-5">
            <h1 className="text-center mb-4">Gestion des Voitures</h1>

            <div className="row">
                <div className="col-md-6">
                    <input
                        type="text"
                        name="marque"
                        className="form-control mb-3"
                        placeholder="Marque"
                        value={newVoiture.marque}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="col-md-6">
                    <input
                        type="number"
                        name="prix"
                        className="form-control mb-3"
                        placeholder="Prix"
                        value={newVoiture.prix}
                        onChange={handleInputChange}
                    />
                </div>
            </div>
            
            <div className="text-center mb-3">
                <button
                    className={`btn ${editing ? 'btn-warning' : 'btn-success'} mx-2`}
                    onClick={editing ? updateVoiture : createVoiture}
                >
                    {editing ? 'Mettre à jour' : 'Ajouter Voiture'}
                </button>
            </div>

            <table className="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Marque</th>
                        <th>Prix</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {voitures.map((voiture) => (
                        <tr key={voiture.id}>
                            <td>{voiture.marque}</td>
                            <td>{voiture.prix} TND</td>
                            <td>
                                <button
                                    className="btn btn-primary mx-2"
                                    onClick={() => editVoiture(voiture)}
                                >
                                    Modifier
                                </button>
                                <button
                                    className="btn btn-danger"
                                    onClick={() => deleteVoiture(voiture.id)}
                                >
                                    Supprimer
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default VoitureCRUD;
