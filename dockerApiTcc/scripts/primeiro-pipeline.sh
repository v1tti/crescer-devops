echo "Executando testes unitários\n"
./mvnw test

echo "\n\nCompilando imagem docker\n"
docker build -t tcc-docker:latest .