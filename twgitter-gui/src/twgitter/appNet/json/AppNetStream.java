package twgitter.appNet.json;

import java.util.List;

import twgitter.gitter.json.Meta;

public class AppNetStream {
	List<Data> data;
	Meta meta;

	public List<Data> getData(){return data;}
	public Meta getMeta(){return meta;}
}
