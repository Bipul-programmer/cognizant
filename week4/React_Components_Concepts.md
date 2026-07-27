# React Components Concepts & Theory - Week 4

## 1. What are React Components?
**React Components** are independent, reusable bits of code that serve as the building blocks of any React application. They work similarly to JavaScript functions, accepting inputs (called **props**) and returning React elements describing what should appear on the screen.

---

## 2. Components vs. Standard JavaScript Functions

| Aspect | React Components | Standard JavaScript Functions |
| :--- | :--- | :--- |
| **Return Value** | Returns JSX (React Elements describing UI). | Returns primitive data types, objects, or `undefined`. |
| **Naming Convention** | Must start with a Capital Letter (e.g., `<Home />`). | CamelCase or lowercase (e.g., `calculateTotal()`). |
| **State & Lifecycle** | Can maintain internal state and hook into React lifecycle events. | No built-in state or UI lifecycle management. |
| **Invocation** | Rendered via JSX syntax (`<MyComponent />`). | Called using standard function calls (`myFunction()`). |

---

## 3. Types of React Components
React has two primary types of components:

1. **Class Components** (ES6 Class-based)
2. **Function Components** (Function-based)

---

## 4. Class Components
A **Class Component** is an ES6 class that extends `React.Component`. It must contain a `render()` method which returns JSX. 

### Characteristics:
- Inherits from `React.Component`.
- Can manage local state via `this.state` initialized in the `constructor(props)`.
- Uses lifecycle methods (e.g., `componentDidMount`, `componentDidUpdate`, `componentWillUnmount`).

### Example:
```javascript
import React, { Component } from 'react';

class Home extends Component {
  render() {
    return <h1>Welcome to the Home page of Student Management Portal</h1>;
  }
}

export default Home;
```

---

## 5. Function Components
A **Function Component** is a plain JavaScript function that accepts `props` as an argument and returns JSX.

### Characteristics:
- Simpler, cleaner, and less boilerplate syntax.
- Manages state and side-effects using **React Hooks** (e.g., `useState`, `useEffect`).
- Preferred standard in modern React development.

---

## 6. Component Constructor (`constructor()`)
In Class Components, the `constructor(props)` is a special method called before the component is mounted.

### Purpose of Constructor:
1. **Initializing Local State:** Assigning an object to `this.state`.
2. **Binding Event Handlers:** Binding `this` context to class methods (e.g., `this.handleClick = this.handleClick.bind(this)`).
3. **`super(props)`:** Calling `super(props)` is mandatory to pass `props` to the parent `React.Component` class.

---

## 7. The `render()` Function
The `render()` method is the **only required method** in a React Class Component.

### Key Rules of `render()`:
- **Pure Function:** It should not modify component state directly or interact with the browser directly.
- **Return Value:** Must return React elements (JSX), arrays, fragments, strings, numbers, or `null`.
- Executed automatically whenever component state or props change.
