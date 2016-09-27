## Apollo Universal Starter Kit with Hot Code Reload of backend & frontend 

> Apollo Universal Starter Kit is an boilerplate for [Universal] web app development built on top of [Apollo], 
> [GraphQL], [React], [Express] with SQL storage support and [Twitter Bootstrap] integration. 
> Hot Code Reload of backend & frontend using [Webpack] and [React Hot Loader 3] to reflect your changes instantly 
> and help you stay productive.

## Hot Code Reload demo
![screencast](https://cloud.githubusercontent.com/assets/1259926/18871714/5d122a8a-84bf-11e6-8d7a-8c941e301fa8.gif)

## Getting Started

1. Clone starter kit locally.

  ```
  git clone git@github.com:sysgears/apollo-fullstack-starter-kit.git
  cd apollo-fullstack-starter-kit
  ```

2. Install dependencies.

  ```
  npm i
  ```

3. Create sample SQLite database schema.

  ```
  npm run migrate
  ```

4. Seed sample database data.

  ```
  npm run seed
  ```

5. Run starter kit in development mode.

  ```
  npm start
  ```

6. Point your browser to http://localhost:3000
7. Change any app code and see the changes applied immediately!

## Deploying to [Heroku]
1. Add your app to Heroku
1. Allow Heroku to install build time dependencies from the devDependencies in package.json:
   `Settings -> Config Variables -> Add`, KEY: `NPM_CONFIG_PRODUCTION`, VALUE: `false`.
1. Deploy your app on Heroku

## Heroku Demo 
You can see latest version of this app deployed to Heroku here:
https://apollo-fullstack-starter-kit.herokuapp.com

## Features
- Hot Code Reload for backend and frontend
Hot Code Reload for backend is done using [Webpack]. When Webpack prepares hot patches on the filesystem,
SIGUSR2 signal is sent to Node.js app and embedded Webpack Hot Module Runtime reacts to this signal and 
applies patches to running modules from filesystem. Hot code reload for frontend is using Webpack Dev Server
and [React Hot Loader 3] to apply patches to frontend code. Hot patches for React components are applied on the 
frontend and backend at the same time, so React should not complain about differences in client and server code.

- Server Side Rendering with Apollo Redux Store sync
On the initial web page request backend fully renders UI and hands off Apollo Redux Store state to frontend. Frontend
then starts off from there and updates itself on user interactions.

- Optimistic UI updates
This example application uses Apollo optimistic UI updates, that result in immediate UI update on user interaction and then, 
after data arrives from the server, UI state is finalized.

- [GraphQL] API
GraphQL is used as very flexible and much faster API in terms of bandwidth and round-trips, compared to REST. 
GraphQL requests are batched together automatically by [Apollo]

- SQL and arbitrary data sources support
[Knex] code to access SQLite is included as an example of using arbitrary data source with [Apollo] and [GraphQL]. 
NoSQL storage or any other data source can be used the same way.

- Powerful stylesheets with Hot Reloading
[Twitter Bootstrap] in form of SASS stylesheets is used for styling demo application. Application has stylesheet
in `styles.scss` for global styling which is Hot Reloaded on change. React components styling is done by [Aphrodite CSS].` 

- [Babel] for ES6 or ES7 transpiling

- [ESLint] to enforce proper code style


## License
Copyright © 2016 [SysGears INC]. This source code is licensed under the [MIT] license.

[MIT]: LICENSE
[Universal]: https://medium.com/@mjackson/universal-javascript-4761051b7ae9
[Apollo]: http://www.apollostack.com
[GraphQL]: http://graphql.org
[React]: https://facebook.github.io/react
[Express]: http://expressjs.com
[Twitter Bootstrap]: http://getbootstrap.com
[Webpack]: http://webpack.github.io
[Babel]: http://babeljs.io
[React Hot Loader 3]: https://github.com/gaearon/react-hot-loader
[Aphrodite CSS]: https://github.com/Khan/aphrodite
[Knex]: http://knexjs.org
[Heroku]: https://heroku.com
[ESLint]: http://eslint.org
[SysGears INC]: http://sysgears.com
