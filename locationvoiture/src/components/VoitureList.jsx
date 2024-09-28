import React, { useEffect, useState } from "react";
import axios from "axios";

const VoitureList = () => {
  const [voitures, setVoitures] = useState([]);

  useEffect(() => {
    axios.get("/api/voitures").then((response) => {
      setVoitures(response.data);
    });
  }, []);

  return (
    <div>
      <h2>List of Voitures</h2>
      <ul>
        {voitures.map((voiture) => (
          <li key={voiture.id}>
            {voiture.marque} - {voiture.prix} €
          </li>
        ))}
      </ul>
    </div>
  );
};

export default VoitureList;
