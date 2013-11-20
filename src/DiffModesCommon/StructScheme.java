/*
 * Класс содержит структурную схему САС в формате svg
 */

package DiffModesCommon;

/**
 *
 * @author radeon
 */
public class StructScheme {
    
    /**@return структурную схему САС для расчетов*/
    public static String getStructScheme() {
        return "<svg width=\"100%\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:ev=\"http://www.w3.org/2001/xml-events\"\n" +
        "xmlns:v=\"http://schemas.microsoft.com/visio/2003/SVGExtensions/\" width=\"9.95092in\" height=\"3.08683in\"\n" +
        "viewBox=\"0 0 716.466 222.252\" xml:space=\"preserve\" color-interpolation-filters=\"sRGB\" class=\"st9\">\n" +
        "<v:documentProperties v:langID=\"1049\" v:viewMarkup=\"false\">\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvNoAutoConnect\" v:val=\"VT0(1):26\"/>\n" +
        "</v:userDefs>\n" +
        "</v:documentProperties>\n" +
        "\n" +
        "<style type=\"text/css\">\n" +
        "<![CDATA[\n" +
        ".st1 {fill:url(#grad30-4);stroke:#000000;stroke-linecap:round;stroke-linejoin:round;stroke-width:1}\n" +
        ".st2 {fill:#000000;font-family:Times New Roman;font-size:1.16666em;font-style:italic;font-weight:bold}\n" +
        ".st3 {font-size:0.857157em;font-style:normal;font-weight:normal}\n" +
        ".st4 {stroke:#000000;stroke-linecap:round;stroke-linejoin:round;stroke-width:1}\n" +
        ".st5 {marker-end:url(#mrkr5-68);stroke:#000000;stroke-linecap:round;stroke-linejoin:round;stroke-width:1}\n" +
        ".st6 {fill:#000000;fill-opacity:1;stroke:#000000;stroke-opacity:1;stroke-width:0.28409090909091}\n" +
        ".st7 {fill:none;stroke:none;stroke-linecap:round;stroke-linejoin:round;stroke-width:0.25}\n" +
        ".st8 {fill:url(#grad30-149);stroke:#000000;stroke-linecap:round;stroke-linejoin:round;stroke-width:0.25}\n" +
        ".st9 {fill:none;fill-rule:evenodd;font-size:12px;overflow:visible;stroke-linecap:square;stroke-miterlimit:3}\n" +
        "]]>\n" +
        "</style>\n" +
        "\n" +
        "<defs id=\"Patterns_And_Gradients\">\n" +
        "<linearGradient id=\"grad30-4\" v:fillPattern=\"30\" v:foreground=\"#f0f0f0\" v:background=\"#ffffff\" x1=\"0\" y1=\"1\" x2=\"0\" y2=\"0\">\n" +
        "<stop offset=\"0\" style=\"stop-color:#f0f0f0;stop-opacity:1\"/>\n" +
        "<stop offset=\"1\" style=\"stop-color:#ffffff;stop-opacity:1\"/>\n" +
        "</linearGradient>\n" +
        "<linearGradient id=\"grad30-149\" v:fillPattern=\"30\" v:foreground=\"#000000\" v:background=\"#000000\" x1=\"0\" y1=\"1\" x2=\"0\"\n" +
        "y2=\"0\">\n" +
        "<stop offset=\"0\" style=\"stop-color:#000000;stop-opacity:1\"/>\n" +
        "<stop offset=\"1\" style=\"stop-color:#000000;stop-opacity:1\"/>\n" +
        "</linearGradient>\n" +
        "</defs>\n" +
        "<defs id=\"Markers\">\n" +
        "<g id=\"lend5\">\n" +
        "<path d=\"M 2 1 L 0 0 L 1.98117 -0.993387 C 1.67173 -0.364515 1.67301 0.372641 1.98465 1.00043 \" style=\"stroke:none\"/>\n" +
        "</g>\n" +
        "<marker id=\"mrkr5-68\" class=\"st6\" v:arrowType=\"5\" v:arrowSize=\"2\" v:setback=\"6.16\" refX=\"-6.16\" orient=\"auto\"\n" +
        "markerUnits=\"strokeWidth\" overflow=\"visible\">\n" +
        "<use xlink:href=\"#lend5\" transform=\"scale(-3.52,-3.52) \"/>\n" +
        "</marker>\n" +
        "</defs>\n" +
        "<g v:mID=\"0\" v:index=\"1\" v:groupContext=\"foregroundPage\">\n" +
        "<title>Page-1</title>\n" +
        "<v:pageProperties v:drawingScale=\"1\" v:pageScale=\"1\" v:drawingUnits=\"19\" v:shadowOffsetX=\"8.50394\"\n" +
        "v:shadowOffsetY=\"-8.50394\"/>\n" +
        "<v:layer v:name=\"Блок-схема\" v:index=\"0\"/>\n" +
        "<v:layer v:name=\"Соединительная линия\" v:index=\"1\"/>\n" +
        "<g id=\"shape1-1\" v:mID=\"1\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(153.43,-89.8661)\">\n" +
        "<title>Процесс.38</title>\n" +
        "<desc>Wk1(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">k</tspan><tspan\n" +
        "class=\"st3\">1</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape2-8\" v:mID=\"2\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(266.816,-89.8661)\">\n" +
        "<title>Процесс.39</title>\n" +
        "<desc>Wk2(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">k</tspan><tspan\n" +
        "class=\"st3\">2</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape3-14\" v:mID=\"3\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(380.202,-89.8661)\">\n" +
        "<title>Процесс.40</title>\n" +
        "<desc>Wd3(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">d</tspan><tspan\n" +
        "class=\"st3\">3</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape4-20\" v:mID=\"4\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(472.328,-160.732)\">\n" +
        "<title>Процесс.41</title>\n" +
        "<desc>Wd4(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">d</tspan><tspan\n" +
        "class=\"st3\">4</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape5-26\" v:mID=\"5\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(564.454,-89.8661)\">\n" +
        "<title>Процесс.42</title>\n" +
        "<desc>Wk5(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">k</tspan><tspan\n" +
        "class=\"st3\">5</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape6-32\" v:mID=\"6\" v:groupContext=\"shape\" v:layerMember=\"0\" transform=\"translate(380.202,-19)\">\n" +
        "<title>Процесс.43</title>\n" +
        "<desc>Wk6(s)</desc>\n" +
        "<v:custProps>\n" +
        "<v:cp v:nameU=\"Cost\" v:lbl=\"Стоимость\" v:prompt=\"\" v:type=\"7\" v:format=\"@\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"ProcessNumber\" v:lbl=\"Номер процесса\" v:prompt=\"\" v:type=\"2\" v:format=\"\" v:sortKey=\"\"\n" +
        "v:invis=\"false\" v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Owner\" v:lbl=\"Владелец\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Function\" v:lbl=\"Функция\" v:prompt=\"\" v:type=\"0\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "<v:cp v:nameU=\"StartDate\" v:lbl=\"Дата начала\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"EndDate\" v:lbl=\"Дата окончания\" v:prompt=\"\" v:type=\"5\" v:format=\"\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\"/>\n" +
        "<v:cp v:nameU=\"Status\" v:lbl=\"Состояние\" v:prompt=\"\" v:type=\"4\"\n" +
        "v:format=\";Не начато;Выполняется;Завершено;Отложено;Ожидается ввод\" v:sortKey=\"\" v:invis=\"false\"\n" +
        "v:ask=\"false\" v:langID=\"1049\" v:cal=\"0\" v:val=\"VT4()\"/>\n" +
        "</v:custProps>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"DefaultWidth\" v:prompt=\"\" v:val=\"VT0(0.98425196850394):24\"/>\n" +
        "<v:ud v:nameU=\"DefaultHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"ResizeTxtHeight\" v:prompt=\"\" v:val=\"VT0(0.59055118110236):24\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"35.4331\" cy=\"200.992\" width=\"70.87\" height=\"42.5197\"/>\n" +
        "<rect x=\"0\" y=\"179.732\" width=\"70.8661\" height=\"42.5197\" class=\"st1\"/>\n" +
        "<text x=\"15.82\" y=\"205.19\" class=\"st2\" v:langID=\"1033\"><v:paragraph v:horizAlign=\"1\"/><v:tabList/>W<tspan class=\"st3\">k</tspan><tspan\n" +
        "class=\"st3\">6</tspan>(s)</text>		</g>\n" +
        "<g id=\"group7-38\" transform=\"translate(493.587,-96.9528)\" v:mID=\"7\" v:groupContext=\"group\">\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<title>Лист.7</title>\n" +
        "<g id=\"shape8-39\" v:mID=\"8\" v:groupContext=\"shape\" v:layerMember=\"1;0\">\n" +
        "<title>Ссылка на текущую страницу</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 208.08 A14.1732 14.1732 0 0 1 28.35 208.08 A14.1732 14.1732 0 1 1 0 208.08 Z\" class=\"st1\"/>\n" +
        "</g>\n" +
        "<g id=\"shape9-42\" v:mID=\"9\" v:groupContext=\"shape\" transform=\"translate(161.283,40.9328) rotate(45.0014)\">\n" +
        "<title>Лист.9</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L28.35 222.25\" class=\"st4\"/>\n" +
        "</g>\n" +
        "<g id=\"shape10-46\" v:mID=\"10\" v:groupContext=\"shape\" transform=\"translate(-152.961,60.9008) rotate(-45)\">\n" +
        "<title>Лист.10</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L28.22 222.25\" class=\"st4\"/>\n" +
        "</g>\n" +
        "</g>\n" +
        "<g id=\"group11-50\" transform=\"translate(82.5639,-96.9528)\" v:mID=\"11\" v:groupContext=\"group\">\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<title>Лист.11</title>\n" +
        "<g id=\"shape12-51\" v:mID=\"12\" v:groupContext=\"shape\" v:layerMember=\"1;0\">\n" +
        "<title>Ссылка на текущую страницу</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"visVersion\" v:prompt=\"\" v:val=\"VT0(14):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 208.08 A14.1732 14.1732 0 0 1 28.35 208.08 A14.1732 14.1732 0 1 1 0 208.08 Z\" class=\"st1\"/>\n" +
        "</g>\n" +
        "<g id=\"shape13-54\" v:mID=\"13\" v:groupContext=\"shape\" transform=\"translate(161.283,40.9328) rotate(45.0014)\">\n" +
        "<title>Лист.13</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L28.35 222.25\" class=\"st4\"/>\n" +
        "</g>\n" +
        "<g id=\"shape14-58\" v:mID=\"14\" v:groupContext=\"shape\" transform=\"translate(-152.961,60.9008) rotate(-45)\">\n" +
        "<title>Лист.14</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L28.22 222.25\" class=\"st4\"/>\n" +
        "</g>\n" +
        "</g>\n" +
        "<g id=\"shape15-62\" v:mID=\"15\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(110.91,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.52</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L36.36 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape16-69\" v:mID=\"16\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(224.296,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.53</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L36.36 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape17-75\" v:mID=\"17\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(337.682,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.54</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L36.36 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape18-81\" v:mID=\"18\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(451.068,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.55</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L36.36 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape19-87\" v:mID=\"19\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(498.761,-160.732)\">\n" +
        "<title>Динамическая соединительная линия.56</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M9 222.25 L9 251.53\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape20-93\" v:mID=\"20\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(521.934,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.57</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L36.36 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape21-99\" v:mID=\"21\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(663.666,-120.126)\">\n" +
        "<title>Динамическая соединительная линия.58</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 231.25 L20.77 231.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape22-105\" v:mID=\"22\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(380.202,-40.2598)\">\n" +
        "<title>Динамическая соединительная линия.59</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L-283.46 222.25 L-283.46 171.72\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape23-111\" v:mID=\"23\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(663.666,-111.126)\">\n" +
        "<title>Динамическая соединительная линия.60</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L0 293.12 L-206.44 293.12\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape24-117\" v:mID=\"24\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(25.871,-102.126)\">\n" +
        "<title>Динамическая соединительная линия.61</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L50.53 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape25-123\" v:mID=\"25\" v:groupContext=\"shape\" v:layerMember=\"1\" transform=\"translate(415.635,-172.992)\">\n" +
        "<title>Динамическая соединительная линия.62</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 213.25 L50.53 213.25\" class=\"st5\"/>\n" +
        "</g>\n" +
        "<g id=\"shape26-129\" v:mID=\"26\" v:groupContext=\"shape\" transform=\"translate(32.9576,-115.378)\">\n" +
        "<title>Лист.26</title>\n" +
        "<desc>G(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>G(s)</text>		</g>\n" +
        "<g id=\"shape27-132\" v:mID=\"27\" v:groupContext=\"shape\" transform=\"translate(119.414,-115.378)\">\n" +
        "<title>Лист.27</title>\n" +
        "<desc>E(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>E(s)</text>		</g>\n" +
        "<g id=\"shape28-135\" v:mID=\"28\" v:groupContext=\"shape\" transform=\"translate(227.131,-115.378)\">\n" +
        "<title>Лист.28</title>\n" +
        "<desc>Y1(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">1</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape29-139\" v:mID=\"29\" v:groupContext=\"shape\" transform=\"translate(339.099,-115.378)\">\n" +
        "<title>Лист.29</title>\n" +
        "<desc>Y2(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">2</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape30-143\" v:mID=\"30\" v:groupContext=\"shape\" transform=\"translate(422.721,-186.244)\">\n" +
        "<title>Лист.30</title>\n" +
        "<desc>F(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>F(s)</text>		</g>\n" +
        "<g id=\"shape31-146\" v:mID=\"31\" v:groupContext=\"shape\" transform=\"translate(662.249,-109.709)\">\n" +
        "<title>Лист.31</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<ellipse cx=\"1.41732\" cy=\"220.835\" rx=\"1.41732\" ry=\"1.41732\" class=\"st8\"/>\n" +
        "</g>\n" +
        "<g id=\"shape32-150\" v:mID=\"32\" v:groupContext=\"shape\" transform=\"translate(663.666,333.378) rotate(180)\">\n" +
        "<title>Лист.32</title>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<path d=\"M0 222.25 L28.35 222.25\" class=\"st4\"/>\n" +
        "</g>\n" +
        "<g id=\"shape33-154\" v:mID=\"33\" v:groupContext=\"shape\" transform=\"translate(100.989,-82.7795)\">\n" +
        "<title>Лист.33</title>\n" +
        "<desc>-</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"4.96063\" cy=\"216.252\" width=\"9.93\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"9.92126\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1049\"><v:paragraph/><v:tabList/>-</text>		</g>\n" +
        "<g id=\"shape34-157\" v:mID=\"34\" v:groupContext=\"shape\" transform=\"translate(456.737,-115.378)\">\n" +
        "<title>Лист.34</title>\n" +
        "<desc>Y3(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">3</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape35-161\" v:mID=\"35\" v:groupContext=\"shape\" transform=\"translate(510.595,-141.976)\">\n" +
        "<title>Лист.35</title>\n" +
        "<desc>Y4(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">4</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape36-165\" v:mID=\"36\" v:groupContext=\"shape\" transform=\"translate(225.713,-45.9291)\">\n" +
        "<title>Лист.36</title>\n" +
        "<desc>Y6(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">6</tspan>(s)</text>		</g>\n" +
        "<g id=\"shape37-169\" v:mID=\"37\" v:groupContext=\"shape\" transform=\"translate(640.989,-115.378)\">\n" +
        "<title>Лист.37</title>\n" +
        "<desc>Y5(s)</desc>\n" +
        "<v:userDefs>\n" +
        "<v:ud v:nameU=\"msvThemeColors\" v:val=\"VT0(36):26\"/>\n" +
        "<v:ud v:nameU=\"msvThemeEffects\" v:val=\"VT0(16):26\"/>\n" +
        "</v:userDefs>\n" +
        "<v:textBlock v:margins=\"rect(2,2,2,2)\" v:tabSpace=\"42.5197\"/>\n" +
        "<v:textRect cx=\"24.0945\" cy=\"216.252\" width=\"48.19\" height=\"12\"/>\n" +
        "<rect x=\"0\" y=\"210.252\" width=\"48.189\" height=\"12\" class=\"st7\"/>\n" +
        "<text x=\"2\" y=\"220.45\" class=\"st2\" v:langID=\"1033\"><v:paragraph/><v:tabList/>Y<tspan class=\"st3\">5</tspan>(s)</text>		</g>\n" +
        "</g>\n" +
        "</svg>";
    }
    
}
