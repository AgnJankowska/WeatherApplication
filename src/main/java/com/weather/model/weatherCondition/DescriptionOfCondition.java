package com.weather.model.weatherCondition;

import java.util.ArrayList;

public class DescriptionOfCondition {

    SingleCondition singleCondition;
    ArrayList<SingleCondition> arrayOfCondition;

    public DescriptionOfCondition() {
        this.singleCondition = new SingleCondition();
        this.arrayOfCondition = new ArrayList<>();
    }

    private void setSingleCondition(int Id, MainCondition main, String description) {
        SingleCondition condition = new SingleCondition();

        condition.setId(Id);
        condition.setMain(main);
        condition.setDescription(description);
        arrayOfCondition.add(condition);
    }

    public void setArrayOfCondition() {
        setSingleCondition(200, MainCondition.THUNDERSTORM, "burza z łagodnymi opadami");
        setSingleCondition(201, MainCondition.THUNDERSTORM, "burza z opadami");
        setSingleCondition(202, MainCondition.THUNDERSTORM, "burza z ulewą");
        setSingleCondition(210, MainCondition.THUNDERSTORM, "łagodna burza");
        setSingleCondition(211, MainCondition.THUNDERSTORM, "burza");
        setSingleCondition(212, MainCondition.THUNDERSTORM, "silna burza");
        setSingleCondition(221, MainCondition.THUNDERSTORM, "silna burza");
        setSingleCondition(230, MainCondition.THUNDERSTORM, "burza z łagodną mżawką");
        setSingleCondition(231, MainCondition.THUNDERSTORM, "burza z mżawką");
        setSingleCondition(232, MainCondition.THUNDERSTORM, "burza z silną mżawką");

        setSingleCondition(300, MainCondition.DRIZZLE, "łagodna mżawka");
        setSingleCondition(301, MainCondition.DRIZZLE, "mżawka");
        setSingleCondition(302, MainCondition.DRIZZLE, "intensywna mżawka");
        setSingleCondition(311, MainCondition.DRIZZLE, "mżawka");
        setSingleCondition(312, MainCondition.DRIZZLE, "intensywna mżawka");
        setSingleCondition(313, MainCondition.DRIZZLE, "przelotne opady");
        setSingleCondition(314, MainCondition.DRIZZLE, "silne przelotne opady");
        setSingleCondition(315, MainCondition.DRIZZLE, "przelotna mżawka");

        setSingleCondition(500, MainCondition.RAIN, "lekkie opady deszczu");
        setSingleCondition(501, MainCondition.RAIN, "opady deszczu");
        setSingleCondition(502, MainCondition.RAIN, "silne opady deszczu");
        setSingleCondition(503, MainCondition.RAIN, "ulewa");
        setSingleCondition(504, MainCondition.RAIN, "silna ulewa");
        setSingleCondition(511, MainCondition.RAIN, "zamarzające opady deszczu");
        setSingleCondition(520, MainCondition.RAIN, "delikatne przelotne opady");
        setSingleCondition(521, MainCondition.RAIN, "przelotne opady");
        setSingleCondition(522, MainCondition.RAIN, "silne przelotne opady");
        setSingleCondition(531, MainCondition.RAIN, "przerywane opady deszczu");

        setSingleCondition(600, MainCondition.SNOW, "lekkie opady śniegu");
        setSingleCondition(601, MainCondition.SNOW, "opady śniegu");
        setSingleCondition(602, MainCondition.SNOW, "silne opady śniegu");
        setSingleCondition(611, MainCondition.SNOW, "opady deszczu ze śniegiem");
        setSingleCondition(612, MainCondition.SNOW, "lekkie opady deszczu i śniegu");
        setSingleCondition(613, MainCondition.SNOW, "przelotne opady deszczu ze śniegiem");
        setSingleCondition(615, MainCondition.SNOW, "lekkie opady deszczu ze śniegiem");
        setSingleCondition(616, MainCondition.SNOW, "opady deszczu ze śniegiem");
        setSingleCondition(620, MainCondition.SNOW, "lekkie przelotne opady śniegu");
        setSingleCondition(621, MainCondition.SNOW, "przelotne opady śniegu");
        setSingleCondition(622, MainCondition.SNOW, "silne przelotne opady śniegu");

        setSingleCondition(701, MainCondition.ATMOSPHERE, "mgła");
        setSingleCondition(711, MainCondition.ATMOSPHERE, "dym");
        setSingleCondition(721, MainCondition.ATMOSPHERE, "zamglenie");
        setSingleCondition(731, MainCondition.ATMOSPHERE, "zapylenie");
        setSingleCondition(741, MainCondition.ATMOSPHERE, "gęsta mgła");
        setSingleCondition(751, MainCondition.ATMOSPHERE, "chmura piaskowa");
        setSingleCondition(761, MainCondition.ATMOSPHERE, "dym");
        setSingleCondition(762, MainCondition.ATMOSPHERE, "popiół wulkaniczny");
        setSingleCondition(771, MainCondition.ATMOSPHERE, "szkwał");
        setSingleCondition(781, MainCondition.ATMOSPHERE, "tornado");

        setSingleCondition(800, MainCondition.CLEAR, "czyste niebo");

        setSingleCondition(801, MainCondition.CLOUDS, "prawie bezchmurne niebo");
        setSingleCondition(802, MainCondition.CLOUDS, "niewielkie zachmurzenie");
        setSingleCondition(803, MainCondition.CLOUDS, "zachmurzenie umiarkowane");
        setSingleCondition(804, MainCondition.CLOUDS, "niebo zachmurzone");
    }

    public ArrayList<SingleCondition> getArrayOfCondition(){
        return this.arrayOfCondition;
    }
}
