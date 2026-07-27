import React, { Component } from 'react';
import './App.css';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="portal-header">
          <div className="portal-badge">Student Management System</div>
          <h1>Student Management Portal</h1>
          <p className="portal-subheading">Rendering Multiple React Class Components</p>
        </header>

        <main className="components-container">
          <Home />
          <About />
          <Contact />
        </main>
      </div>
    );
  }
}

export default App;
