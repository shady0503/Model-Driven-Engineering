# 📦 MDE Generator - Distribution Guide

## ✅ Portable Distribution Created!

I've created a **fully portable distribution** that can be installed on any computer without depending on the MDE source directory.

---

## 📂 What Was Created

### 1. Distribution Package: `dist/mde-gen-3.5.6.zip` (18 MB)

This ZIP file contains everything needed to run `mde-gen` on any computer:

```
mde-gen-3.5.6/
├── mde-gen.jar                    # Standalone executable (~21 MB)
├── install-portable.ps1           # Auto-installer for Windows
├── INSTALL.md                     # Installation guide
├── README.md                      # Quick start guide
├── bin/
│   ├── mde-gen.bat               # Windows CMD launcher
│   ├── mde-gen.ps1               # PowerShell launcher
│   └── mde-gen.sh                # Linux/Mac bash launcher
├── examples/
│   ├── healthcare-system.yaml
│   ├── social-media-platform.yaml
│   └── financial-trading-platform.yaml
└── docs/
    ├── README.md
    ├── INSTALL.md
    ├── CLI_DESIGN.md
    └── QUICK_START.md
```

---

## 🚀 How to Use on Another Computer

### Option 1: Automated Installation (Windows)

```powershell
# 1. Copy mde-gen-3.5.6.zip to the new computer
# 2. Extract the ZIP
# 3. Open PowerShell in the extracted folder
# 4. Run:
.\install-portable.ps1

# 5. Restart terminal
# 6. Use from anywhere:
mde-gen --help
mde-gen generate $env:MDE_EXAMPLES\healthcare-system.yaml
```

**What the installer does:**
- Copies files to `C:\Users\<username>\AppData\Local\Programs\mde-gen`
- Adds `bin` directory to User PATH
- Sets `MDE_EXAMPLES` environment variable
- No admin rights required!

### Option 2: Manual Installation (Windows)

```powershell
# 1. Extract to: C:\Tools\mde-gen-3.5.6
# 2. Add to PATH: C:\Tools\mde-gen-3.5.6\bin
# 3. Set env var: MDE_EXAMPLES = C:\Tools\mde-gen-3.5.6\examples
# 4. Restart terminal
# 5. Run: mde-gen --help
```

### Option 3: Use Without Installation

```powershell
# 1. Extract the ZIP anywhere
# 2. Navigate to folder
cd C:\Temp\mde-gen-3.5.6

# 3. Run directly
.\bin\mde-gen.bat --help
.\bin\mde-gen.bat generate examples\healthcare-system.yaml
```

### Linux/Mac Installation

```bash
# 1. Extract
unzip mde-gen-3.5.6.zip
cd mde-gen-3.5.6

# 2. Make executable
chmod +x bin/mde-gen.sh

# 3. Add to ~/.bashrc
echo 'export PATH="$PATH:$(pwd)/bin"' >> ~/.bashrc
echo 'export MDE_EXAMPLES="$(pwd)/examples"' >> ~/.bashrc

# 4. Reload and test
source ~/.bashrc
mde-gen.sh --help
```

---

## 🎯 Key Features of This Distribution

### ✅ Fully Portable
- No dependency on source MDE directory
- Self-contained JAR with all dependencies
- Works from any installation location

### ✅ Cross-Platform
- Windows (batch + PowerShell scripts)
- Linux (bash script)
- Mac (bash script)

### ✅ Example Files Included
- 3 ready-to-use YAML examples
- Accessible via `$env:MDE_EXAMPLES` shortcut
- No need to specify long paths

### ✅ Easy Installation
- Automated installer (install-portable.ps1)
- Manual installation guide
- No-install option (run from extracted folder)

### ✅ Small Size
- Only 18 MB ZIP file
- Easy to email or upload
- Fast download/extraction

---

## 📝 Usage After Installation

```powershell
# Quick examples (works from ANY directory)
mde-gen --help
mde-gen generate $env:MDE_EXAMPLES\healthcare-system.yaml
mde-gen validate $env:MDE_EXAMPLES\social-media-platform.yaml

# Custom models
mde-gen generate C:\MyProjects\my-model.yaml -o C:\Output\my-api
mde-gen validate D:\Models\ecommerce.yaml --strict

# With options
mde-gen -v generate $env:MDE_EXAMPLES\healthcare-system.yaml  # Verbose
mde-gen generate model.yaml --clean --no-zip  # Clean + no ZIP
```

---

## 🔧 How to Create Distribution (For Developers)

If you make changes to the code and want to create a new distribution:

```powershell
# 1. Build the project
.\mvnw.cmd clean package

# 2. Create distribution
.\create-distribution.ps1

# Result: dist/mde-gen-<version>.zip
```

The script automatically:
- Creates `dist/mde-gen-<version>/` folder
- Copies JAR, examples, docs
- Creates launcher scripts
- Generates INSTALL.md
- Creates install-portable.ps1
- Packages everything into ZIP

---

## 🗂️ Distribution Files Created

### Main Scripts

1. **create-distribution.ps1** (in MDE root)
   - Creates the portable ZIP package
   - Run this to build distribution

2. **install.ps1** (in MDE root)  
   - Alternative installer for local installation
   - Copies files to specified location

### In the ZIP Package

3. **install-portable.ps1** (in ZIP)
   - Automated installer for end users
   - Included in the distribution ZIP

4. **INSTALL.md** (in ZIP)
   - Installation instructions
   - Generated automatically

5. **README.md** (in ZIP)
   - Quick start guide for users

---

## ✅ Testing on Another Computer

To verify the distribution works:

1. **Copy** `dist/mde-gen-3.5.6.zip` to a different computer
2. **Extract** the ZIP
3. **Run** `install-portable.ps1`
4. **Restart** terminal
5. **Test:**
   ```powershell
   mde-gen --help
   mde-gen generate $env:MDE_EXAMPLES\healthcare-system.yaml
   ```

---

## 📊 Distribution Contents

| File/Folder | Size | Purpose |
|-------------|------|---------|
| mde-gen.jar | 21 MB | Main application |
| bin/ | 3 KB | Launcher scripts |
| examples/ | 34 KB | Sample YAML files |
| docs/ | 100 KB | Documentation |
| install-portable.ps1 | 2 KB | Auto-installer |
| INSTALL.md | 3 KB | Install guide |
| **Total ZIP** | **18 MB** | **Complete package** |

---

## 🎉 Ready to Distribute!

The distribution package is ready at:
```
C:\Users\achra\Desktop\MDE\dist\mde-gen-3.5.6.zip
```

You can now:
- ✅ Email it to colleagues
- ✅ Upload to GitHub releases
- ✅ Share via cloud storage
- ✅ Install on any Windows/Linux/Mac computer
- ✅ Use without admin rights (user installation)

---

**No more long paths! No more MDE directory dependency!** 🚀
