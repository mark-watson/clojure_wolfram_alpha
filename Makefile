setup:
	lein deps
	cp local_lib/* lib/

clean:
	lein clean
	rm -r -f lib
	