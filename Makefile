clean:
	make -C app clean

build:
	make -C app clean build

install:
	make -C app clean install

run-dist:
	make -C app run-dist

run:
	make -C app clean
	make -C app run

test:
	make -C app test

lint:
	make -C app lint

report:
	make -C app report

wrapper:
	make -C app wrapper

build-run: build run

.PHONY: build
