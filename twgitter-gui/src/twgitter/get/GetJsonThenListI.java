package twgitter.get;

import java.util.List;

public interface GetJsonThenListI {
	public String getJSONString() throws Exception;

	public List<?> jsonToList(String json);

	public String nameToId(String wantNameOrId) throws Exception;
}
