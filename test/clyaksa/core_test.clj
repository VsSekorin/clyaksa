(ns clyaksa.core-test
  (:require [clojure.test :refer :all]
            [clyaksa.core :refer :all])
  (:import (java.awt.image BufferedImage)))

(deftest new-image-size-test
  (testing "new image return with correct size"
    (let [size 100
          image (new-image size :rgb)]
      (is (= (class image) BufferedImage))
      (is (= (.getWidth image) size))
      (is (= (.getHeight image) size))
      (is (= (.getType image) BufferedImage/TYPE_INT_RGB)))))

(deftest new-image-width-height-test
  (testing "new image return with correct size"
    (let [width 200
          height 300
          image (new-image width height :argb)]
      (is (= (class image) BufferedImage))
      (is (= (.getWidth image) width))
      (is (= (.getHeight image) height))
      (is (= (.getType image) BufferedImage/TYPE_INT_ARGB)))))

(deftest set-pixel-test
  (testing "set pixel"
    (let [x 6
          y 6
          color 0x00ff00
          image (new-image 10 10 :argb)]
      (set-pixel image x y color)
      (is (= (.getRGB image x y) color))
      (is (not (= (.getRGB image (inc x) y) color))))))

(deftest get-pixel-test
  (testing "get pixel"
    (let [x 6
          y 6
          color 0x00ff00
          image (new-image 10 10 :argb)]
      (.setRGB image x y color)
      (is (= (get-pixel image x y) color))
      (is (not (= (get-pixel image (inc x) y) color))))))

(deftest get-height-test
  (testing "get height"
    (let [height 6
          image (new-image 10 height :rgb)]
      (is (= height (get-height image))))))

(deftest get-width-test
  (testing "get width"
    (let [width 6
          image (new-image width 10 :rgb)]
      (is (= width (get-width image))))))

(deftest swap-pixel-one-test
  (testing "swap pixel in one image"
    (let [image (new-image 10 10 :argb)]
      (.setRGB image 4 4 100)
      (.setRGB image 6 6 200)
      (is (= 100 (.getRGB image 4 4)))
      (is (= 200 (.getRGB image 6 6)))
      (swap-pixel image 4 4 6 6)
      (is (= 200 (.getRGB image 4 4)))
      (is (= 100 (.getRGB image 6 6))))))

(deftest swap-pixel-two-test
  (testing "swap pixel in two different images"
    (let [image1 (new-image 10 10 :argb)
          image2 (new-image 15 15 :argb)]
      (.setRGB image1 4 4 100)
      (.setRGB image2 6 6 200)
      (is (= 100 (.getRGB image1 4 4)))
      (is (= 200 (.getRGB image2 6 6)))
      (swap-pixel image1 image2 4 4 6 6)
      (is (= 200 (.getRGB image1 4 4)))
      (is (= 100 (.getRGB image2 6 6))))))
