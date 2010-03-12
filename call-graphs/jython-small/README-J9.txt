We produced the static call graphs for jython using J9. The reason for this is that the HotSpot VM segfaults when
analyzing jython with Soot. This is due to a known bug in HotSpot that is triggered when managing large heaps.

Unfortunately, the XML implementation in J9 seems buggy: the GXL files that ProBe produces when run on J9 is missing
the xlink namespace attributes. We therefore post-processed the GXL files with sed to adapt the namespace. We did not
alter the GXL files in any other way.