URL=$1
URL=${URL%$'\r'}

curl --fail --location $1
