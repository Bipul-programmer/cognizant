import React from 'react';
import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <h1>Student Score Calculator</h1>
        <p>Student Management Portal - Functional Component Lab</p>
      </header>

      <main className="app-main">
        <CalculateScore
          Name={"Steeve"}
          School={"D.A.V Public School"}
          Total={284}
          goal={300}
        />
      </main>
    </div>
  );
}

export default App;
