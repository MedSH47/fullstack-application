import React, { useState } from "react";
import axios from "axios";

const VoitureForm = () => {
  const [marque, setMarque] = useState("");
  const [prix, setPrix] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("/api/voitures", { marque, prix }).then((response) => {
      console.log(response.data);
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Marque"
        value={marque}
        onChange={(e) => setMarque(e.target.value)}
      />
      <input
        type="number"
        placeholder="Prix"
        value={prix}
        onChange={(e) => setPrix(e.target.value)}
      />
      <button type="submit">Add Voiture</button>
    </form>
  );
};

export default VoitureForm;
