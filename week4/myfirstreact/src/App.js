import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <div className="card-container">
        <div className="badge">React Hands-on Lab</div>
        <h1>welcome to the first session of React</h1>
        <p className="subtitle">
          Your React environment is successfully set up and running on <code>localhost:3000</code>.
        </p>
        <div className="feature-grid">
          <div className="feature-card">
            <h3>⚡ Component Driven</h3>
            <p>Reusable UI elements for modular web apps.</p>
          </div>
          <div className="feature-card">
            <h3>🚀 Virtual DOM</h3>
            <p>Fast in-memory reconciliation for maximum performance.</p>
          </div>
          <div className="feature-card">
            <h3>🌐 Single Page Application</h3>
            <p>Fluid, seamless desktop-like user experience.</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
