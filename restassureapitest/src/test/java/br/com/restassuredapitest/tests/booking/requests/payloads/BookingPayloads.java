package br.com.restassuredapitest.tests.booking.requests.payloads;

import org.json.JSONObject;

public class BookingPayloads {

    public JSONObject payloadValidBooking() {

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        payload.put("firstname", "Lucas");
        payload.put("lastname", "Smith");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "Breakfast");

        return payload;
    }

    public JSONObject payloadInvalido() {

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("2checkin", "2018-01-01");
        bookingDates.put("1checkout", "2019-01-01");

        payload.put("name", "Lucas");
        payload.put("outroName", "Smith");
        payload.put("totalValor", 111);
        payload.put("deposit", true);
        payload.put("dates", bookingDates);
        payload.put("needs", "Breakfast");

        return payload;
    }

    public JSONObject payloadComMaisParametros() {

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        payload.put("firstname", "Lucas");
        payload.put("lastname", "Smith");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("cidade", "São Paulo");
        payload.put("pais", "Brasil");
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "Breakfast");

        return payload;

    }

}
