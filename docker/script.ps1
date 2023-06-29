cd ..
docker build -t paulacg/webapp16 -f docker/Dockerfile .
cd ./docker
docker push paulacg/webapp16