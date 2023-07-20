(ns build
  (:refer-clojure :exclude [test])
  (:require [org.corfield.build :as bb]))

(def lib 'piku/sample-clojure-app)
(def version "0.1.0-SNAPSHOT")
(def main 'sample-clojure-app.core)
(def worker 'sample-clojure-app.worker)
(def cronjob 'sample-clojure-app.cronjob)

(defn test "Run tests" [opts]
  (bb/run-tests opts))

(defn clean "Run clean" [opts]
  (bb/clean opts))

(defn uber "Run uberjar" [opts]
  (-> opts
      (assoc :lib lib
             :version version
             :main main
             :ns-compile [main
                          worker
                          cronjob])
      (bb/uber)))

(defn release "Run full release with tests" [opts]
  (-> opts test clean uber))
