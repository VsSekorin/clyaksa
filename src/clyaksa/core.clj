(ns clyaksa.core
  (:require [clojure.string :refer [last-index-of]])
  (:import (java.awt.image BufferedImage)
           (javax.imageio ImageIO)
           (java.io File)))

(def image-types
  {:custom   BufferedImage/TYPE_CUSTOM
   :rgb      BufferedImage/TYPE_INT_RGB
   :argb     BufferedImage/TYPE_INT_ARGB
   :argb-pre BufferedImage/TYPE_INT_ARGB_PRE
   :bgr      BufferedImage/TYPE_INT_BGR})

(defn new-image
  ([size type-key] (new-image size size type-key))
  ([width height type-key]
   (BufferedImage. width height (type-key image-types))))

(defn set-pixel
  [image x y color]
  (.setRGB image x y (int color))
  image)

(defn get-pixel
  [image x y]
  (.getRGB image x y))

(defn save-image
  ([image filename]
   (save-image image filename (subs filename (inc (last-index-of filename ".")) (.length filename))))
  ([image filename type]
   (ImageIO/write image (name type) (File. filename))))
