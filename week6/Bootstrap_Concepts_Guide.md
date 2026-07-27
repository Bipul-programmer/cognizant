# Bootstrap 5 Concepts & Theory - Week 6

## 1. Setting Up Bootstrap 5 (Exercise 1.1 & 1.2)
Bootstrap 5 can be included in a project in two primary ways:
1. **CDN (Content Delivery Network):** Adding `<link>` and `<script>` tags directly to `index.html` referencing files hosted online (e.g., jsDelivr). This is the fastest way for prototyping.
2. **NPM & Package Managers:** Running `npm install bootstrap` downloads the source Sass and JS files. This allows for deep customization (like overriding core colors) via SCSS before compiling to a final CSS file.

## 2. Bootstrap Structure and Files (Exercise 2.1)
When downloading the source files (or via NPM), the Bootstrap directory is structured as follows:
- **`scss/` (or `css/` in precompiled versions):** Contains all the modular stylesheet files. The SCSS version contains components, utilities, and variables broken down into dozens of partials.
- **`js/`:** Contains the JavaScript plugins (e.g., Modals, Dropdowns, Accordions). `bootstrap.bundle.min.js` includes Popper.js, which is required for tooltips and popovers.
- **`icons/` (Bootstrap Icons):** Often distributed as a separate package (`npm i bootstrap-icons`), it provides SVGs and icon web fonts used to add visual icons to UI components.

## 3. Customization with Sass (Exercise 19)
Bootstrap 5 is built with Sass. Customizing it involves:
1. Creating a `custom.scss` file.
2. Creating a `_variables.scss` file where you define overrides (e.g., `$primary: #8a2be2;`).
3. Importing `_variables.scss` *before* importing the core `bootstrap.scss`.
4. Compiling `custom.scss` into a final CSS file using a build tool like Webpack, Vite, or the `sass` CLI.
