# klima-back
Aplicación backend para consultar la previsión climatológica

## Ejecutar aplicación en local
Prerrequisitos:
- Tener instalado Docker Desktop (versión superior a la 4.37.1): https://docs.docker.com/

Pasos
- Ejecutar en terminal el siguiente comando para descargar la imagen de la aplicación klima-back:
```bash
docker pull yasinmunoz/klima-back
``` 
- Puedes consultar el repositorio de la imagen alojado en Docker Hub en esta dirección: https://hub.docker.com/r/yasinmunoz/klima-back
- Ejecutar en terminal el siguiente comando para levantar un contenedor con la imagen descargada:
```bash
docker run -d -p 8080:8080 --name klima-back-container yasinmunoz/klima-back
```
- La aplicación estará levantada en el puerto 8080 de tu localhost.