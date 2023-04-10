ACCIONES

- Crea una cuenta bancaria
- Envia mensaje a topico con el id de la cuenta creada de manera asincrona

PROMPT PARA GTP
- Crear un microservicio cuentas-bancarias-register para hacer un registro de cuentas banciaras
- Internamente debe grabar en BD y hacer  envio de los mensajes a topicos de apache kafka
- Crear un microservicio cuentas-bancarias-read para consumir los mensajes del topico de apache kafka
- Hasta ahi tienes 2 microservicios: Uno es un API con un endpoint REST, el otro api asincrona que consume  mensajes del topico.



*********************
- COMANDOS KAFKA




COMANDO APACHE KAFKA

INICIAR/DETENER ZOOKEPER
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/zookeeper-server-stop.sh

Valida que esté iniciado el zookeper
$ ps aux | grep zookeeper



INICIAR KAFKA
bin/kafka-server-start.sh config/server.properties
bin/kafka-server-stop.sh

INICIAR SCHEMA REGISTRY
bin/schema-registry-start etc/schema-registry/schema-registry.properties

VER MENSAJES DE TOPICOS POR PARTITIONS
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
--topic cuentas-bancarias \
--from-beginning \
--property print.partition=true \
--property print.offset=true \
--property print.timestamp=true


LIMPIAR MENSAJES DE UN TOPICO (reset offsets)
- LATEST
  bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 \
  --group console-consumer-98859 \
  --reset-offsets --to-latest --execute --all-topics

- EARLIEST
  bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 \
  --group console-consumer-42891 \
  --reset-offsets --to-earliest --execute --all-topics


VER MENSAJES DE UN TOPICO YA CONSUMIDOS
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group console-consumer-42891 --describe

LAG: Indica la cantidad de mensajes que faltan leer

ejemplo:
GROUP                  TOPIC             PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
console-consumer-42891 cuentas-bancarias 0          70              80              10              -               -               -%





--------------------------------------------------------------------------------------------------------
TOPICOS


CREAR TOPICOS
bin/kafka-topics.sh --create --topic cuentas-bancarias --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
bin/kafka-topics.sh --create --topic notificaciones-correos --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
bin/kafka-topics.sh --create --topic fraude-transacciones --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1



LISTAR TOPICOS
bin/kafka-topics.sh --list --bootstrap-server localhost:9092


DESCRIBE TOPICS
bin/kafka-topics.sh --describe cuentas-bancarias --bootstrap-server localhost:9092


ENVIAR MENSAJES A TOPICO (PRODUCER)
bin/kafka-console-producer.sh --topic cuentas-bancarias --bootstrap-server localhost:9092

VERIFICAR CUANTAS PARTICIONES TIENE UN TOPICO
bin/kafka-topics.sh --describe --topic cuentas-bancarias --bootstrap-server localhost:9092


CONSUMIR MENSAJES DE TOPICO (CONSUMMER)
bin/kafka-console-consumer.sh --topic cuentas-bancarias --from-beginning --bootstrap-server localhost:9092


LISTAR MENSAJES DE UN TOPICO

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cuentas-bancarias --formatter kaka.tools.DefaultMessageFormatter --property print.key=true --property print.value=true --property print.partition=true --property print.offset=true

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cuentas-bancarias



ELIMINAR UN TOPICO
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic cuentas-bancarias


ELIMINAR MENSAJES DE UN TOPICO
bin/kafka-log-dirs.sh --bootstrap-server localhost:9092 --describe --topic-list cuentas-bancarias
bin/kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file delete.json





----------------------------
CONSUMER GROUPS

LISTA CONSUMER GROUPS
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list


VER DETALLE DE UN CONSUMER GROUP
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group console-consumer-4146 --describe

CONSULTA LOS CONSUMIDORES DE UN TOPICO EN ESPECIFICO
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --all-groups | grep "cuentas-bancarias"





----------------------------
REGISTRY-SCHEMA (AVRO/JSON	)

- Desde la descarga del schema-registry, ejecutar el comando para cargar el localhost:8081 (8084)

CARGAR SCHEMA REGISTRY

bin/schema-registry-start etc/schema-registry/schema-registry.properties






----------------------------
CREAR SCHEMA AVRO TOPICO
curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" \
--data @schema.json \
http://localhost:8084/subjects/cuentas-bancarias/versions


ELIMINAR SCHEMA AVRO DE TOPICO
curl -X DELETE http://localhost:8084/subjects/cuentas-bancarias


LIMPIAR MENSAJES DE UN TOPICO (reset offsets)
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 \
--group console-consumer-98859 \
--reset-offsets --to-latest --execute --all-topics




