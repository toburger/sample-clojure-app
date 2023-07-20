(ns build
  (:refer-clojure :exclude [test])
  (:require [org.corfield.build :as bb]))

(def lib 'piku/sample-clojure-app)
(def version "0.1.0-SNAPSHOT")
(def main 'sample-clojure-app.core)

(defn test "Run tests" [opts]
  (bb/run-tests opts))

(defn clean "Run clean" [opts]
  (bb/clean opts))

(defn uber "Run uberjar" [opts]
  (bb/uber opts))

(defn ci "Run full CI with tests" [opts]
  (-> opts
      (assoc :lib lib :version version :main main)
      (bb/run-tests)
      (bb/clean)
      (bb/uber)))