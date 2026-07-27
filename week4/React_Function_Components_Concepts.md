# React Function Components & Component Styling - Week 4

## 1. What is a React Function Component?
A **Function Component** in React is a plain JavaScript function that receives `props` (properties) as an argument and returns React elements (JSX).

### Syntax:
```javascript
import React from 'react';

const CalculateScore = ({ Name, School, Total, goal }) => {
  const average = (Total / goal).toFixed(2);
  return (
    <div className="score-card">
      <h2>Student Details</h2>
      <p>Name: {Name}</p>
      <p>School: {School}</p>
      <p>Total Score: {Total}</p>
      <p>Goal: {goal}</p>
      <p>Average Score: {average}</p>
    </div>
  );
};

export default CalculateScore;
```

---

## 2. Function Components vs. Class Components

| Feature | Function Components | Class Components |
| :--- | :--- | :--- |
| **Syntax** | JavaScript functions returning JSX. | ES6 Classes extending `React.Component`. |
| **Boilerplate** | Concise, readable, minimal boilerplate. | Verbose, requires `render()` method and class syntax. |
| **State Management** | Handled via `useState` hook. | Handled via `this.state` and `this.setState()`. |
| **`this` Keyword** | No `this` keyword needed. | Relies heavily on `this` context binding. |
| **Performance** | Slightly lightweight and faster to parse. | Has additional class instance overhead. |

---

## 3. Component Props (Properties)
**Props** are arguments passed into React components. They are passed down from parent components to child components via JSX attributes (Unidirectional Data Flow).

- Props are **read-only** (immutable).
- A child component must never modify its own `props`.

### Passing Props Example:
```jsx
<CalculateScore 
  Name="John Doe" 
  School="Springfield High" 
  Total={280} 
  goal={3} 
/>
```

---

## 4. Applying Styles to React Components
React supports multiple ways to style components:

1. **External Stylesheets (CSS Files):** Importing `.css` files into component files (e.g., `import '../Stylesheets/mystyle.css'`).
2. **Inline Styling:** Passing a JavaScript object to the `style` attribute (e.g., `<div style={{ color: 'blue', fontSize: '18px' }}>`).
3. **CSS Modules:** Scoped CSS files to prevent class name conflicts (`Component.module.css`).
4. **Styled Components / CSS-in-JS:** Utilizing libraries like `styled-components` or `emotion`.

In this lab, we use an external stylesheet `mystyle.css` stored in the `src/Stylesheets` directory.
