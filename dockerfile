FROM nginx:1.28.1-alpine

COPY nginx.conf /etc/nginx

#try using nginx as a webserver to serve html page
COPY index.html /html/index.html
COPY myimage.jpg /html/content/myimage.jpg

EXPOSE 8000
EXPOSE 8080