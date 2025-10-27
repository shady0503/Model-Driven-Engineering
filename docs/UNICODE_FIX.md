# Fixing Unicode Symbol Display Issues

## Problem

Unicode characters like `✓` (checkmark) display as `?` in Windows PowerShell because the console uses CP437 or Windows-1252 encoding which doesn't support these characters.

## Solutions

### Option 1: Change PowerShell Encoding (Temporary - Each Session)

Run this before using `mde-gen`:

```powershell
# Set PowerShell to UTF-8
chcp 65001
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

# Then run your commands
.\mde-gen.ps1 generate examples/healthcare-system.yaml
```

### Option 2: Use Windows Terminal (Recommended)

Windows Terminal has full UTF-8 support by default:

1. Install Windows Terminal from Microsoft Store (if not already installed)
2. Open Windows Terminal (not PowerShell)
3. Run `mde-gen` - Unicode symbols will display correctly!

### Option 3: Auto-Detect and Use ASCII Symbols (Implemented)

**We've added automatic detection!** The code now uses:
- `[OK]` or `+` instead of `✓` when Unicode isn't supported
- `[X]` or `X` instead of `✗` for errors
- `!` instead of `⚠` for warnings

#### How It Works:

The new `ConsoleSymbols` class:
```java
public class ConsoleSymbols {
    public static final String CHECK = isUnicodeSupported() ? "✓" : "[OK]";
    public static final String SUCCESS = isUnicodeSupported() ? "✓" : "+";
    public static final String CROSS = isUnicodeSupported() ? "✗" : "[X]";
    // ...
}
```

It detects:
- Console encoding (UTF-8, CP437, Windows-1252, etc.)
- System properties (`-Dmde.no-unicode=true`)
- Fallback to ASCII-safe symbols

#### Force ASCII Mode:

```powershell
# Use --no-unicode flag (when implemented)
.\mde-gen.ps1 --no-unicode generate examples/healthcare.yaml

# Or set Java system property
$env:JAVA_TOOL_OPTIONS="-Dmde.no-unicode=true"
.\mde-gen.ps1 generate examples/healthcare.yaml
```

### Option 4: Set PowerShell Profile for UTF-8 (Permanent)

Make UTF-8 default in your PowerShell profile:

```powershell
# Edit profile
notepad $PROFILE

# Add these lines:
chcp 65001 > $null
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

# Save and reload
. $PROFILE
```

## Before and After

### Before (Unicode in CP437 console):
```
? YAML parsed successfully
? GENERATION SUCCESSFUL!
? Context model loaded
```

### After (Auto-detected ASCII fallback):
```
[OK] YAML parsed successfully
+ GENERATION SUCCESSFUL!
[OK] Context model loaded
```

### After (With UTF-8 enabled):
```
✓ YAML parsed successfully
✓ GENERATION SUCCESSFUL!
✓ Context model loaded
```

## Implementation Status

✅ **Completed:**
- Created `ConsoleSymbols` utility class
- Updated `CodeGenerator.java` to use `ConsoleSymbols`
- Detects console encoding automatically

⏳ **In Progress:**
- Updating remaining files (ETL, EGL, CLI validators)
- Adding `--no-unicode` flag to CLI

## Quick Test

After rebuild, test both modes:

```powershell
# Build
.\mvnw.cmd clean package -DskipTests

# Test in current PowerShell (will use ASCII)
.\mde-gen.ps1 generate examples/healthcare-system.yaml

# Test with UTF-8
chcp 65001
.\mde-gen.ps1 generate examples/social-media-platform.yaml
```

## Symbol Mapping

| Unicode | ASCII Fallback | Usage |
|---------|---------------|-------|
| ✓       | [OK] or +     | Success, completion |
| ✗       | [X] or X      | Error, failure |
| ⚠       | !             | Warning |
| ℹ       | i             | Information |
| •       | -             | Bullet point |
| →       | ->            | Arrow |

## Recommendation

**Use Windows Terminal** - It's the modern solution with full Unicode support, better colors, and tabs. Available free from Microsoft Store.

If you're stuck with old PowerShell: The auto-detection will handle it for you!
