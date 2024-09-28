import React from 'react';
import MyComponent from './components/Mycomponent'; // Import the component that fetches data
import Hello from "./components/Hello"
const App = () => {
    return (
        <div>
            <h1>My React App</h1>
            <Hello/>
        </div>
    );
};

export default App;
