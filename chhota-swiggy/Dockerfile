FROM node:20 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve the Angular app using Nginx
FROM nginx:alpine
COPY --from=build /app/dist/chhota-swiggy /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]