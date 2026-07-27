import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMsg: ''
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map((item) => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch((error) => {
        this.componentDidCatch(error, 'Error fetching posts from API');
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert(`An error occurred in Posts component: ${error}`);
    this.setState({ hasError: true, errorMsg: error.toString() });
  }

  render() {
    if (this.state.hasError) {
      return (
        <div className="error-box">
          <h2>Something went wrong!</h2>
          <p>{this.state.errorMsg}</p>
        </div>
      );
    }

    return (
      <div className="posts-container">
        <h1>Blog Posts</h1>
        {this.state.posts.length === 0 ? (
          <p className="loading-text">Loading posts...</p>
        ) : (
          this.state.posts.map((post) => (
            <div key={post.id} className="post-card">
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Posts;
