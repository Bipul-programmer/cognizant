import React, { Component } from 'react';
import './App.css';
import Posts from './Posts';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="blog-header">
          <div className="blog-badge">React Lifecycle Lab</div>
          <h1>Blog Application</h1>
          <p>Demonstrating componentDidMount() & componentDidCatch()</p>
        </header>

        <main className="blog-content">
          <Posts />
        </main>
      </div>
    );
  }
}

export default App;
