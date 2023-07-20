release: ./install-prerequisites.sh
jwsgi: java -jar target/uberjar/sample-clojure-app-0.1.0-SNAPSHOT-standalone.jar
worker: ./bin/bb worker.clj
cron: */1 * * * * ./bin/bb hello.clj