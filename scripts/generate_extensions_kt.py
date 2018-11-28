types = ["Int", "Long", "Float", "Double", "Short", "Byte"]
lines = []

print("Create math extensions for types: " + str(types))

lines.append("")
lines.append("// Unary minus")
lines.append("")

for type in types:
    lines.append("@JvmName(\"property" + type + "UnaryMinus\")")
    lines.append("operator fun ReadOnlyProperty<" + type + ">.unaryMinus() = mapBinding(" + type + "::unaryMinus)")
    lines.append("")

lines.append("// List sum")
lines.append("")

for type in types:
    lines.append("@JvmName(\"observableList" + type + "Sum\")")
    lines.append("fun ObservableReadOnlyList<" + type + ">.sumObservable() = mapBinding { it.sum() }")
    lines.append("")

lines.append("// List average")
lines.append("")

for type in types:
    lines.append("@JvmName(\"observableList" + type + "Average\")")
    lines.append("fun ObservableReadOnlyList<" + type + ">.averageObservable() = mapBinding { it.average() }")
    lines.append("")

lines.append("/*")
lines.append(" * Property - Property")
lines.append(" */")
lines.append("")

for type1 in types:
    for type2 in types:
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.plus(property: ReadOnlyProperty<" + type2 + ">) = join(property, " + type1 + "::plus)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.minus(property: ReadOnlyProperty<" + type2 + ">) = join(property, " + type1 + "::minus)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.times(property: ReadOnlyProperty<" + type2 + ">) = join(property, " + type1 + "::times)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.div(property: ReadOnlyProperty<" + type2 + ">) = join(property, " + type1 + "::div)")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.rem(property: ReadOnlyProperty<" + type2 + ">) = join(property, " + type1 + "::rem)")
        lines.append("")

lines.append("/*")
lines.append(" * Property - primitive")
lines.append(" */")
lines.append("")

for type1 in types:
    for type2 in types:
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.plus(value: " + type2 + ") = mapBinding { it + value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.minus(value: " + type2 + ") = mapBinding { it - value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.times(value: " + type2 + ") = mapBinding { it * value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.div(value: " + type2 + ") = mapBinding { it / value }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun ReadOnlyProperty<" + type1 + ">.rem(value: " + type2 + ") = mapBinding { it % value }")
        lines.append("")

lines.append("/*")
lines.append(" * primitive - Property")
lines.append(" */")
lines.append("")

for type1 in types:
    for type2 in types:
        lines.append("// " + type1 + " - " + type2)
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Plus" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".plus(property: ReadOnlyProperty<" + type2 + ">) = property.mapBinding { this + it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Minus" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".minus(property: ReadOnlyProperty<" + type2 + ">) = property.mapBinding { this - it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Times" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".times(property: ReadOnlyProperty<" + type2 + ">) = property.mapBinding { this * it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Div" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".div(property: ReadOnlyProperty<" + type2 + ">) = property.mapBinding { this / it }")
        lines.append("")
        lines.append("@JvmName(\"property" + type1 + "Rem" + type2 + "\")")
        lines.append(
            "operator fun " + type1 + ".rem(property: ReadOnlyProperty<" + type2 + ">) = property.mapBinding { this % it }")
        lines.append("")

function_count = 0

while lines[len(lines) - 1] == "":
    del lines[len(lines) - 1]

file_name = "src/commonMain/kotlin/de/westermann/kobserve/Extensions.kt"

print("Write to '" + file_name + "'...")

header = []
with open("../" + file_name, "r") as f:
    for line in f:
        header.append(line.rstrip())
        if line.strip() == "/* The following part is auto generated. Do NOT edit it manually! */":
            break

with open("../" + file_name, "w") as f:
    for item in header:
        f.write("%s\n" % item)

    for item in lines:
        if "fun " in item:
            function_count += 1

        f.write("%s\n" % item)

print(str(function_count) + " functions generated.")
