# Use Node to build the Angular app
FROM node:18 AS build
WORKDIR /usr/src/app
COPY package*.json ./
COPY angular.json ./
COPY tsconfig*.json ./
COPY src ./src
RUN npm install
RUN npm run build -- --outputPath=dist

# Use nginx to serve built files
FROM nginx:stable-alpine
COPY --from=build /usr/src/app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
