types = ["Int", "Long", "Float", "Double", "Short", "Byte"]
values = ["5", "4L", "3.0f", "2.0", "6.toShort()", "1.toByte()"]
lines = []
test = []

def appendBoth(line):
    lines.append(line)
    test.append(line)

print("Create math extensions for types: " + str(types))

appendBoth("")
appendBoth("// Unary minus")
appendBoth("")

for type, value in zip(types, values):
    lines.append("@JvmName(\"property" + type + "UnaryMinus\")")
    lines.append("operator fun ObservableValue<" + type + ">.unaryMinus() = mapBinding { -it }")
    lines.append("")

    test.append("@Test")
    test.append("fun property" + type + "UnaryMinusTest() {")
    test.append("    val p1 = property(" + value + ")")
    test.append("    val p = -p1")
    test.append("    assertEquals(-p1.value, p.value)")
    test.append("}")
    test.append("")

appendBoth("// List sum")
appendBoth("")

for type, value in zip(types, values):
    lines.append("@JvmName(\"observableList" + type + "Sum\")")
    lines.append("fun ObservableCollection<" + type + ">.sumObservable() = mapBinding { it.sum() }")
    lines.append("")

    test.append("@Test")
    test.append("fun observableList" + type + "SumTest() {")
    test.append("    val p1 = observableListOf(" + value + ", " + value + ", " + value + ")")
    test.append("    val p = p1.sumObservable()")
    test.append("    assertEquals(p1.value.sum(), p.value)")
    test.append("}")
    test.append("")

appendBoth("// List average")
appendBoth("")

for type, value in zip(types, values):
    lines.append("@JvmName(\"observableList" + type + "Average\")")
    lines.append("fun ObservableCollection<" + type + ">.averageObservable() = mapBinding { it.average() }")
    lines.append("")

    test.append("@Test")
    test.append("fun observableList" + type + "AverageTest() {")
    test.append("    val p1 = observableListOf(" + value + ", " + value + ", " + value + ")")
    test.append("    val p = p1.averageObservable()")
    test.append("    assertEquals(p1.value.average(), p.value)")
    test.append("}")
    test.append("")

appendBoth("/*")
appendBoth(" * Property - Property")
appendBoth(" */")
appendBoth("")

for type1, value1 in zip(types, values):
    for type2, value2 in zip(types, values):
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.plus(property: ObservableValue<" + type2 + ">) = join(property, " + type1 + "::plus)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.minus(property: ObservableValue<" + type2 + ">) = join(property, " + type1 + "::minus)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.times(property: ObservableValue<" + type2 + ">) = join(property, " + type1 + "::times)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.div(property: ObservableValue<" + type2 + ">) = join(property, " + type1 + "::div)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.rem(property: ObservableValue<" + type2 + ">) = join(property, " + type1 + "::rem)")
        lines.append("")

        test.append("@Test")
        test.append("fun property" + type1 + "Plus" + type2 + "Test() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 + p2")
        test.append("    assertEquals(p1.value + p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Minus" + type2 + "Test() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 - p2")
        test.append("    assertEquals(p1.value - p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Times" + type2 + "Test() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 * p2")
        test.append("    assertEquals(p1.value * p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Div" + type2 + "Test() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 / p2")
        test.append("    assertEquals(p1.value / p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Rem" + type2 + "Test() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 % p2")
        test.append("    assertEquals(p1.value % p2.value, p.value)")
        test.append("}")
        test.append("")

appendBoth("/*")
appendBoth(" * Property - primitive")
appendBoth(" */")
appendBoth("")

for type1, value1 in zip(types, values):
    for type2, value2 in zip(types, values):
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.plus(value: " + type2 + ") = mapBinding { it + value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.minus(value: " + type2 + ") = mapBinding { it - value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.times(value: " + type2 + ") = mapBinding { it * value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.div(value: " + type2 + ") = mapBinding { it / value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun ObservableValue<" + type1 + ">.rem(value: " + type2 + ") = mapBinding { it % value }")
        lines.append("")

        test.append("@Test")
        test.append("fun property" + type1 + "Plus" + type2 + "PrimitiveTest() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = " + value2)
        test.append("    val p = p1 + p2")
        test.append("    assertEquals(p1.value + p2, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Minus" + type2 + "PrimitiveTest() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = " + value2)
        test.append("    val p = p1 - p2")
        test.append("    assertEquals(p1.value - p2, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Times" + type2 + "PrimitiveTest() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = " + value2)
        test.append("    val p = p1 * p2")
        test.append("    assertEquals(p1.value * p2, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Div" + type2 + "PrimitiveTest() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = " + value2)
        test.append("    val p = p1 / p2")
        test.append("    assertEquals(p1.value / p2, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "Rem" + type2 + "PrimitiveTest() {")
        test.append("    val p1 = property(" + value1 + ")")
        test.append("    val p2 = " + value2)
        test.append("    val p = p1 % p2")
        test.append("    assertEquals(p1.value % p2, p.value)")
        test.append("}")
        test.append("")

lines.append("/*")
lines.append(" * primitive - Property")
lines.append(" */")
lines.append("")

for type1, value1 in zip(types, values):
    for type2, value2 in zip(types, values):
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".plus(property: ObservableValue<" + type2 + ">) = property.mapBinding { this + it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".minus(property: ObservableValue<" + type2 + ">) = property.mapBinding { this - it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".times(property: ObservableValue<" + type2 + ">) = property.mapBinding { this * it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".div(property: ObservableValue<" + type2 + ">) = property.mapBinding { this / it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".rem(property: ObservableValue<" + type2 + ">) = property.mapBinding { this % it }")
        lines.append("")

        test.append("@Test")
        test.append("fun property" + type1 + "PrimitivePlus" + type2 + "Test() {")
        test.append("    val p1 = " + value1)
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 + p2")
        test.append("    assertEquals(p1 + p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "PrimitiveMinus" + type2 + "Test() {")
        test.append("    val p1 = " + value1)
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 - p2")
        test.append("    assertEquals(p1 - p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "PrimitiveTimes" + type2 + "Test() {")
        test.append("    val p1 = " + value1)
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 * p2")
        test.append("    assertEquals(p1 * p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "PrimitiveDiv" + type2 + "Test() {")
        test.append("    val p1 = " + value1)
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 / p2")
        test.append("    assertEquals(p1 / p2.value, p.value)")
        test.append("}")
        test.append("")
        test.append("@Test")
        test.append("fun property" + type1 + "PrimitiveRem" + type2 + "Test() {")
        test.append("    val p1 = " + value1)
        test.append("    val p2 = property(" + value2 + ")")
        test.append("    val p = p1 % p2")
        test.append("    assertEquals(p1 % p2.value, p.value)")
        test.append("}")
        test.append("")

function_count = 0

while lines[len(lines) - 1] == "":
    del lines[len(lines) - 1]

file_name = "src/commonMain/kotlin/de/westermann/kobserve/Extensions.kt"

print("Write to '" + file_name + "'...")

header = []
with open(file_name, "r") as f:
    for line in f:
        header.append(line.rstrip())
        if line.strip() == "/* The following part is auto generated. Do NOT edit it manually! */":
            break

with open(file_name, "w") as f:
    for item in header:
        f.write("%s\n" % item)

    for item in lines:
        if "fun " in item:
            function_count += 1

        f.write("%s\n" % item)

print(str(function_count) + " functions generated.")


function_count = 0

while test[len(test) - 1] == "":
    del test[len(test) - 1]

file_name = "src/commonTest/kotlin/de/westermann/kobserve/ExtensionsTest.kt"

print("Write to '" + file_name + "'...")

header = []
with open(file_name, "r") as f:
    for line in f:
        header.append(line.rstrip())
        if line.strip() == "/* The following part is auto generated. Do NOT edit it manually! */":
            break

with open(file_name, "w") as f:
    for item in header:
        f.write("%s\n" % item)

    for item in test:
        if "fun " in item:
            function_count += 1

        f.write("    %s\n" % item)

    f.write("}\n")

print(str(function_count) + " test functions generated.")
