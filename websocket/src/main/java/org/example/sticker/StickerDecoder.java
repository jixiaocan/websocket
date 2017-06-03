package org.example.sticker;

import java.io.IOException;
import java.io.Reader;

import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.spi.JsonProvider;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class StickerDecoder implements Decoder.TextStream<Sticker> {

	// Do not create a JsonReader object. To create readers and writes, use the
	// JsonProvider class.

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public Sticker decode(Reader reader) throws DecodeException, IOException {
		JsonProvider provider = JsonProvider.provider();
		JsonReader jsonReader = provider.createReader(reader);
		JsonObject jsonSticker = jsonReader.readObject();
		Sticker sticker = new Sticker();
		sticker.setX(jsonSticker.getInt("x"));
		sticker.setY(jsonSticker.getInt("y"));
		sticker.setImage(jsonSticker.getString("sticker"));
		return sticker;
	}

}
