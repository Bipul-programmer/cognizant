# React Component Lifecycle & Lifecycle Hooks - Week 4

## 1. Need & Benefits of Component Lifecycle
In React Class Components, the **Component Lifecycle** represents the series of events and phases a component goes through from its initialization and creation to its rendering, updating, and unmounting from the DOM.

### Benefits of Component Lifecycle:
- **Resource Management:** Allows initialization of API connections, timers, and subscriptions when a component enters the DOM, and cleanup when it leaves.
- **Performance Optimization:** Provides methods like `shouldComponentUpdate()` to prevent unnecessary re-renders.
- **Error Boundaries:** Allows capturing UI runtime errors gracefully via `componentDidCatch()` instead of crashing the entire application.
- **Predictable Execution:** Guarantees specific execution sequences for data fetching and DOM manipulation.

---

## 2. Phases & Lifecycle Hook Methods

React Class Component lifecycle consists of four main phases:

```
Initialization ➔ Mounting ➔ Updating ➔ Unmounting ➔ (Error Handling)
```

### A. Mounting Phase (Created & Inserted into DOM)
1. **`constructor(props)`**: Initializes state and binds event handlers.
2. **`static getDerivedStateFromProps(props, state)`**: Updates state based on initial props changes.
3. **`render()`**: Evaluates JSX and returns React elements.
4. **`componentDidMount()`**: Invoked immediately after component is inserted into the DOM. Best place for API data fetching (e.g., `fetch()`).

### B. Updating Phase (Triggered by Props or State Change)
1. **`static getDerivedStateFromProps()`**
2. **`shouldComponentUpdate(nextProps, nextState)`**: Determines if rendering can be skipped.
3. **`render()`**: Re-renders component UI.
4. **`getSnapshotBeforeUpdate(prevProps, prevState)`**: Captures DOM info (e.g., scroll position) right before updates are committed.
5. **`componentDidUpdate(prevProps, prevState)`**: Executed after re-rendering and DOM updates.

### C. Unmounting Phase (Removed from DOM)
1. **`componentWillUnmount()`**: Performs cleanup tasks (e.g., invalidating timers, canceling network requests, removing event listeners).

### D. Error Handling Phase
1. **`static getDerivedStateFromError(error)`**: Renders a fallback UI.
2. **`componentDidCatch(error, info)`**: Catches JavaScript errors anywhere in child component tree and logs error information or displays alerts.

---

## 3. Sequence of Steps in Rendering a Component
1. **Trigger:** Initial render call or state/prop change.
2. **Render Phase:** React executes the component's `render()` method to build a new Virtual DOM tree (pure, side-effect free).
3. **Reconciliation (Diffing):** React compares the new Virtual DOM with the previous Virtual DOM tree.
4. **Commit Phase:** React updates the real DOM with minimum necessary operations.
5. **Post-Commit Hooks:** React executes post-render lifecycle methods: `componentDidMount()` on initial mount, or `componentDidUpdate()` on subsequent updates.

---

## 4. `componentDidMount()` Hook
`componentDidMount()` is executed once immediately after the component is rendered into the DOM.

### Common Use Cases:
- Fetching data from remote APIs (e.g., `fetch("https://jsonplaceholder.typicode.com/posts")`).
- Setting up subscriptions or timer intervals (`setInterval`).
- Interacting with DOM nodes directly (e.g., measuring dimensions or setting focus).

---

## 5. `componentDidCatch()` Error Boundary Hook
`componentDidCatch(error, info)` acts as a JavaScript `try-catch` block for React UI component trees.

```javascript
componentDidCatch(error, info) {
  alert("An error occurred: " + error);
  console.error("Component Error:", error, info);
}
```

### Benefits:
- Prevents white-screen crashes for the entire web application.
- Allows displaying fallback error UIs or alert notifications gracefully.
