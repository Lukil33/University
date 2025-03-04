#!/bin/bash

for i in '$1/*'; do
ffmpeg -i $i output.mkv
done